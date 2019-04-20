/*
*/
set pagesize 0
set lines 2000
set feedback off
WHENEVER SQLERROR EXIT SQL.SQLCODE

/* Oracle Version*/
select 'oracle_version '||substr(banner,1,instr(banner,' ')-1) version
from
(    select substr(banner,instr(banner,'Release ')+8) banner
     from v$version
     where banner like '%Oracle%'
);

select 'current_scn '||current_scn from v$database;

select 'thread '||value from v$parameter where name='thread';
/*
**  Column "resetlogs_id" exists in v$database_incarnation only
**  in Oracle 10 or higher.
**  The query is executed in Dynamic SQL so that we can handle the
**  possibility that the column does not exist.
*/
set serveroutput on
declare
   -- declare dynamic cursor type.
   type     dyncur_type is ref cursor;
   dyncur   dyncur_type;

   l_output varchar2(100);
begin
   -- Query resetlogs_id
   -- open  dyncur for 'select resetlogs_id from v$database_incarnation where status = 'CURRENT';
   open  dyncur for 'select resetlogs_id from v$database_incarnation order by status';
   fetch dyncur into l_output;

   dbms_output.put_line('resetlogs_id '||l_output);
exception
    when others then
        -- If col does not exist, the query will raise the following error:
        -- ORA-00904: "RESETLOGS_ID": invalid identifier
        if sqlcode = -904 then
            dbms_output.put_line('resetlogs_id 0');
        else
            -- Something else is wrong, so re-raise error.
            raise;
        end if;
end;
/

/* archive mode */
select 'archive_mode '|| log_mode 
from v$database;

/* Archive format */
select 'archive_format ' || value 
from v$parameter 
where name = 'log_archive_format';

/* instance_name */
 select 'instance_name '||value from v$parameter where name = 'instance_name';
 
/* DB_RECOVERY_FILE_DEST */
--show parameter DB_RECOVERY_FILE_DEST;
 select 'recovery_file_dest '||name from V$RECOVERY_FILE_DEST;

/* Archive Destination */
select 'archive_destination '||destination
from   v$archive_dest
where  status = 'VALID' -- and destination like '+DATA%'
and    exists
   (select 1
    from   v$database
    where  log_mode in ('ARCHIVELOG','MANUAL')
   )
union all
select 'archive_destination '||'NULL'
from   v$archive_dest
where  status = 'VALID' -- and destination like '+DATA%' 
and    not exists
   (select 1
    from   v$database
    where  log_mode in ('ARCHIVELOG','MANUAL')
   );

/* 
/* Redo log file states */
select mem from( select  'logfile ' || member as mem from  v$logfile f,gv$log l where   (upper(f.status) = 'STALE' or f.status is NULL) and f.group#=l.group# and l.group# =1    order by mem asc) where rownum=1
union
select mem from( select  'logfile ' || member as mem from  v$logfile f,gv$log l where   (upper(f.status) = 'STALE' or f.status is NULL) and f.group#=l.group# and l.group# =2    order by mem asc) where rownum=1
union
select mem from( select  'logfile ' || member as mem from  v$logfile f,gv$log l where   (upper(f.status) = 'STALE' or f.status is NULL) and f.group#=l.group# and l.group# =3    order by mem asc) where rownum=1
union
select mem from( select  'logfile ' || member as mem from  v$logfile f,gv$log l where   (upper(f.status) = 'STALE' or f.status is NULL) and f.group#=l.group# and l.group# =4    order by mem asc) where rownum=1
union
select mem from( select  'logfile ' || member as mem from  v$logfile f,v$log l where   (upper(f.status) = 'STALE' or f.status is NULL) and f.group#=l.group# and l.group#  =5    order by mem asc) where rownum=1 
union
select mem from( select  'logfile ' || member as mem from  v$logfile f,v$log l where   (upper(f.status) = 'STALE' or f.status is NULL) and f.group#=l.group# and l.group#  =6    order by mem asc) where rownum=1 
union
select mem from( select  'logfile ' || member as mem from  v$logfile f,v$log l where   (upper(f.status) = 'STALE' or f.status is NULL) and f.group#=l.group# and l.group#  =7    order by mem asc) where rownum=1 
union
select mem from( select  'logfile ' || member as mem from  v$logfile f,v$log l where   (upper(f.status) = 'STALE' or f.status is NULL) and f.group#=l.group# and l.group#  =8    order by mem asc) where rownum=1 
union
select mem from( select  'logfile ' || member as mem from  v$logfile f,v$log l where   (upper(f.status) = 'STALE' or f.status is NULL) and f.group#=l.group# and l.group#  =9     order by mem asc) where rownum=1 
union
select mem from( select  'logfile ' || member as mem from  v$logfile f,v$log l where   (upper(f.status) = 'STALE' or f.status is NULL) and f.group#=l.group# and l.group# =10     order by mem asc) where rownum=1 
union
select mem from( select  'logfile ' || member as mem from  v$logfile f,v$log l where   (upper(f.status) = 'STALE' or f.status is NULL) and f.group#=l.group# and l.group# =11     order by mem asc) where rownum=1 
union
select mem from( select  'logfile ' || member as mem from  v$logfile f,v$log l where   (upper(f.status) = 'STALE' or f.status is NULL) and f.group#=l.group# and l.group# =12      order by mem asc) where rownum=1 
union
select mem from( select  'logfile ' || member as mem from  v$logfile f,v$log l where   (upper(f.status) = 'STALE' or f.status is NULL) and f.group#=l.group# and l.group# =13      order by mem asc) where rownum=1 
union
select mem from( select  'logfile ' || member as mem from  v$logfile f,v$log l where   (upper(f.status) = 'STALE' or f.status is NULL) and f.group#=l.group# and l.group# =14      order by mem asc) where rownum=1;

 col full_path format a128
 col file_nmuber format a8
 col gname format a32
 col dir format a1
 col sys format a1
select 'asm_file ',concat ('+'|| gname, sys_connect_by_path (aname,'/')) full_path, file_number, gname,decode(dir,'Y',1,0),decode(sys,'Y',1,0) 
from 
(select g.name gname,a.parent_index pindex,a.file_number file_number, a.name aname,a.reference_index rindex,a.alias_directory dir,a.system_created sys from v$asm_alias a, v$asm_diskgroup g where a.group_number = g.group_number) 
start with (mod(pindex, power(2, 24))) = 0 connect by prior rindex = pindex order by dir desc, full_path asc;

/* Table and Column */
col tab_id_noprint noprint
col col_id_noprint noprint

select obj.obj#    tab_id_noprint
,      -9999999    col_id_noprint
--,      'table '||lower(usr.name)||' '||obj.obj#||' '||lower(obj.name)
  ,      'table '||usr.name||' '||obj.obj#||' '||obj.name
from
(
  select obj.obj#,obj.owner#,obj.name
  from   
  (select obj.obj#,obj.owner#,obj.name from sys.obj$ obj where obj.type#  = 2 or obj.type#  = 19) obj LEFT OUTER JOIN       
       sys.tab$  tab
  on  tab.obj#   = obj.obj#) obj
, sys.user$ usr
where 
  obj.owner# = usr.user#
union all
select tab.obj#    tab_id_noprint
,      segcol#     col_id_noprint
,      'column '||cOl.segcol#||' '||col.type#||' '||col.length || ' ' ||
--       DECODE(lob.lobj#,NULL,0,lob.lobj#)||' '||col.charsetid||' '||lower(col.name)
       DECODE(lob.lobj#,NULL,0,lob.lobj#)||' '||col.charsetid||' '||col.name
from   sys.tab$  tab
,      sys.obj$  obj
,      sys.user$ usr
,      sys.col$  col
,      sys.lob$  lob
where  tab.obj#   = obj.obj#
and    obj.owner# = usr.user#
and    col.obj#   = tab.obj#
and    lob.obj#    (+) = col.obj#
and    lob.col#    (+) = col.segcol#
and    lob.intcol# (+) = col.intcol#
and    cOl.segcol#>0
order by tab_id_noprint,col_id_noprint
/
exit;