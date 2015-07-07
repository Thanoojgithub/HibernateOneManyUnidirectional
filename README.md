# HibernateOneManyUnidirectional
Hibernate OneMany Unidirectional

------------------------------------------------------------------------------------------------------------------------------------------------------

Hibernate: /* insert com.hibernateonemanybidirectional.pojo.RegOffice */ insert into MYDB.REG_OFFICE (OID, LOCATION, REG_O_ID) values (default, ?, ?)
Hibernate: values identity_val_local()
Hibernate: /* insert com.hibernateonemanybidirectional.pojo.Vehicle */ insert into MYDB.VEHICLE (VID, V_REGNO, REG_OID) values (default, ?, ?)
Hibernate: values identity_val_local()
Hibernate: /* insert com.hibernateonemanybidirectional.pojo.Vehicle */ insert into MYDB.VEHICLE (VID, V_REGNO, REG_OID) values (default, ?, ?)
Hibernate: values identity_val_local()
Hibernate: /* create one-to-many row com.hibernateonemanybidirectional.pojo.RegOffice.vehicles */ <b>update MYDB.VEHICLE set REG_OID=? where VID=?</b>
Hibernate: /* create one-to-many row com.hibernateonemanybidirectional.pojo.RegOffice.vehicles */ <b>update MYDB.VEHICLE set REG_OID=? where VID=?</b>

---------------------------------------------------------------------------------------------------

unidirectional one-to-many association on a foreign key is an unusual case, and is not recommended.
There are two aspects to this:

unidirectional
one-to-many

The thread @Calm Storm links to addresses only the second of these things, but let's start with it.
That thread recommends replacing one-to-many relationships with join tables because otherwise the one-to-many approach 'populates the many side table with columns that don't belong to that entity, are there only for "linking" porpuses (sic)'. This tactic may result in a clean model in the Hibernate layer but unfortunately it results in a broken database.
Because SQL can only assert that the child record has a parent; there is no way to enforce a rule that the parent must have a child. Consequently there is no way to insist that a table have entries in a join table, the upshot being that it becomes possible to have orphaned child records, the very thing that foreign keys are intended to prevent.
I have several other objections, but the next most important one is inappropriateness. Intersection tables are meant to represent many-to-many relationships. Using them to represent one-to-many relationships is confusing and requires too many additional database objects for my liking.
So, to the second aspect: unidirectional one-to-many associations. The problem with these is the peculiar fashion in which Hibernate handles them by default. If we insert a parent and a child in the same transaction, Hibernate inserts the child record, then it inserts the parent, then it updates the child with the parent's key. This requires deferrable foreign key constraints (yuck!) and probably deferrable not null constraints as well (double yuck).
There are a couple of workarounds to this. One is to use birectional one-to-many associations. According to in the document you cite this is the most common approach. The other approach is to tweak the mapping of the child object but that has its own ramifications.
