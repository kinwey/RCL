package com.kw.rcl.design.api.checklist.afterdesign;

import java.io.InputStream;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 改造之后的API
 * @author kinwey
 * @Date 2019-04-27
 */
public class AfterCheckAPI {
    /**
     * Before
     */
    public static Message[] getAllMessages(Mailbox[] mailboxes) throws MailboxException {
        Message[] result = new Message[0];
        for (Mailbox mailbox : mailboxes) {
            Message[] messages = mailbox.getMessages(mailbox.getAllMessages());
            result = Arrays.copyOf(result, result.length + messages.length);
            System.arraycopy(messages, 0, result, result.length, messages.length);
        }
        return result;
    }

    /**
     * After
     */
    public static SortedSet<MessageHeader> readAllMessageHeaders(Set<Mailbox<?>> mailboxes) throws RemoteException {
        SortedSet<MessageHeader> result = new TreeSet<MessageHeader>();
        for(Mailbox<?> mailbox : mailboxes) {
            result.addAll(mailbox.readAllMessageHeaders());
        }
        return result;
    }
}

/**


 * add package overview (package-info.java) for the redesigned API
 * @see com.kw.rcl.design.api.checklist.afterdesign.Package_info
 */




/**
 * Contains descriptive (structured) information about a message and
 * defines methods for retrieving the (unstructured) message body. [2.7.3]
 * Read-only (immutable) instances of this abstract type are
 * read from a Mailbox implementation. [2.7.5]
 * Concrete derived types may offer additional information or functionality, like {@link EmailHeader}. [2.3.4]
 * The natural ordering is the order of reception.
 * For a code sample, see {@link Mailbox}.. [2.7.6, 2.7.9]
 */
public abstract class MessageHeader implements Comparable, Serializable { //also 2.2.4, 2.2.8, 2.2.10, 2.3.11, 2.3.12, 2.3.17

    MessageHeader() {} //also 2.3.9, 2.3.21

    @Override
    public boolean equals(Object obj) {...}
    @Override
    public int hashCode() {...}
    @Override
    public String toString() {...}
    @Override
    public int compareTo(Object o) {...} //also 2.3.10, 2.3.11

    /**
     * Returns the unique (within this message’s mailbox) message ID.
     * @return The message ID.
     */
    public long getId() {...}

    /**
     * Returns a human-readable text summary of the message.
     * @return A human-readable text summary of the message. In some
     * messaging systems this would map to the "subject" field. Not null.
     */
    public String getSummary() {...}

    /**
     * Returns the Internet MIME type of the message content.
     * @return The Internet MIME type of the message content. Not null.
     */
    public String getMimeType() {...}

    /**
     * Access the content of the message from the remote mailbox. [item 3.9.14]
     *
     * @return An input stream for reading the message content. Not null.
     * @throws RemoteException In case of a communication error with a remote mailbox
     * @throws MailboxException Unrecoverable internal mailbox error
     */
    public abstract InputStream streamContent() throws RemoteException, MailboxException;
}

/**
2b  * Represents a generic and abstract mailbox interface for accessing incoming messages. [2.7.3]
2c  * Several implementations based on various messaging protocols (POP3, IMAP, RSS, etc.) are available.
 * Configured instances of mailboxes are retrieved by performing a JNDI lookup. [2.7.5]
2e  * The code sample below prints out the summary of all messages from the default mailbox. [2.7.6]
2f  * <pre>
 *     Context context = new InitialContext();
2h  *     Mailbox<?> mb = (Mailbox<?>) context.lookup("com/env/mailbox/default");
2i  *     for(MessageHeader h : mb.readAllMessageHeaders()) {
2j  *         System.out.println(h); //uses toString()
2k  *     }
2l  * </pre>
2m  */
public abstract class Mailbox<T extends MessageHeader> implements Comparable {//also 2.1.10, 2.3.11

    public static final String NAME_PROPERTY = "mailboxName";

    Mailbox() {...} //also 2.3.9, 2.3.21

    @Override
    public boolean equals(Object obj) {...}

    @Override
    public int hashCode() {...}

    @Override
    public String toString() {...}

    @Override
    public int compareTo(Object o) {...} //also 2.3.10, 2.3.11

    /**
     * Retrieve all messages available in the mailbox.
     *
     * @return The ordered set of all available message headers. Not null.
     * @throws RemoteException In case of a communication error with a remote mailbox
     * @throws MailboxException Unrecoverable internal mailbox error
     */
    public abstract SortedSet<T> readAllMessageHeaders()
        throws RemoteException, MailboxException; //also 3.1.3, 3.1.9, 3.3.9

    /**
     * Retrieve all messages received after the specified message.
     *
     * @param last The last read message header; not null.
     * @return The ordered set of message headers since the lst read message header. Not null.
     * @throws NullPointerException If parameter is null
     * @throws RemoteException In case of a communication error with a remote mailbox
     * @throws MailboxException Unrecoverable internal mailbox error
     */
    public abstract SortedSet<T> readMessageHeadersSince(T last)
        throws NullPointerException, RemoteException, MailboxException; //also 3.1.3, 3.1.9, 3.3.9, 3.4.6, 3.4.12

    /**
     * Mark the specified messages as read on the back-end
     * messagesource, where supported,e.g.IMAP supports this
     * feature.
     *
     * @param headers The list of message headers to be marked; not null.
     * @throws NullPointerException If parameter is null
     * @throws RemoteException In case of a communication error with a remote mailbox
     * @throws MailboxException Unrecoverable internal mailbox error
     */
    public abstract void markRead(Collection<T> headers)
        throws NullPointerException, RemoteException,
        MailboxException; //also 3.1.3, 3.1.9, 3.1.10, 3.3.9, 3.4.6, 3.4.12

    public abstract void markRead(T header)
        throws NullPointerException, RemoteException, MailboxException; //also 3.1.3

    /**
     * Mark the specified messages as unread on the back-end
     * messagesource, where supported,e.g.IMAP supports this
     * feature.
     *
     * @param headers The list of message headers to be marked
     * @throws NullPointerException If parameter is null
     * @throws RemoteException In case of a communication error with a remote mailbox
     * @throws MailboxException Unrecoverable internal mailbox error
     */
    public abstract void markUnread(Collection<T> headers)
        throws NullPointerException, RemoteException, MailboxException;

    public abstract void markUnread(T header)
        throws NullPointerException, RemoteException, MailboxException;
}

/**
 * MessageReaderException no longer needed,delete it
 */



/**
* Signals an unrecoverable internal mailbox error.
*/
class MailboxException extends RuntimeException{
    public MailboxException(String message) {
       super(message);
    }

    public MailboxException(Throwable cause){
      super(cause);
    }

    public MailboxException(String message,Throwable cause){
       super(message,cause);
    }

    /* IMPLEMENTATION STUFF */
    private static final long serialVersionUID = 1L;
}