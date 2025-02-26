/*
 * This file is generated by jOOQ.
 */
package com.okeicalm.simpleJournalEntry;


import com.okeicalm.simpleJournalEntry.tables.Accounts;
import com.okeicalm.simpleJournalEntry.tables.JournalEntries;
import com.okeicalm.simpleJournalEntry.tables.Journals;
import com.okeicalm.simpleJournalEntry.tables.records.AccountsRecord;
import com.okeicalm.simpleJournalEntry.tables.records.JournalEntriesRecord;
import com.okeicalm.simpleJournalEntry.tables.records.JournalsRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * simple_journal_entry_db.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AccountsRecord> KEY_ACCOUNTS_CODE = Internal.createUniqueKey(Accounts.ACCOUNTS, DSL.name("KEY_accounts_code"), new TableField[] { Accounts.ACCOUNTS.CODE }, true);
    public static final UniqueKey<AccountsRecord> KEY_ACCOUNTS_PRIMARY = Internal.createUniqueKey(Accounts.ACCOUNTS, DSL.name("KEY_accounts_PRIMARY"), new TableField[] { Accounts.ACCOUNTS.ID }, true);
    public static final UniqueKey<JournalEntriesRecord> KEY_JOURNAL_ENTRIES_PRIMARY = Internal.createUniqueKey(JournalEntries.JOURNAL_ENTRIES, DSL.name("KEY_journal_entries_PRIMARY"), new TableField[] { JournalEntries.JOURNAL_ENTRIES.ID }, true);
    public static final UniqueKey<JournalsRecord> KEY_JOURNALS_PRIMARY = Internal.createUniqueKey(Journals.JOURNALS, DSL.name("KEY_journals_PRIMARY"), new TableField[] { Journals.JOURNALS.ID }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<JournalEntriesRecord, JournalsRecord> JOURNAL_ENTRIES_IBFK_1 = Internal.createForeignKey(JournalEntries.JOURNAL_ENTRIES, DSL.name("journal_entries_ibfk_1"), new TableField[] { JournalEntries.JOURNAL_ENTRIES.JOURNAL_ID }, Keys.KEY_JOURNALS_PRIMARY, new TableField[] { Journals.JOURNALS.ID }, true);
    public static final ForeignKey<JournalEntriesRecord, AccountsRecord> JOURNAL_ENTRIES_IBFK_2 = Internal.createForeignKey(JournalEntries.JOURNAL_ENTRIES, DSL.name("journal_entries_ibfk_2"), new TableField[] { JournalEntries.JOURNAL_ENTRIES.ACCOUNT_ID }, Keys.KEY_ACCOUNTS_PRIMARY, new TableField[] { Accounts.ACCOUNTS.ID }, true);
}
