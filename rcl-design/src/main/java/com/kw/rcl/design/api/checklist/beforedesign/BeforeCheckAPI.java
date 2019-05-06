package com.kw.rcl.design.api.checklist.beforedesign;

import java.io.InputStream;

/**
 * 检查之前的API
 * @author kinwey
 * @Date 2019-04-27
 */
public class BeforeCheckAPI {
}

interface Message{//see 2.1.8, 2.2.18, 2.4.1, 2.7.1

    /**
     * @return The unique (within this message’s mailbox) message ID. //see 3.9.3
     */
    public long getId();

    /**
     * @return  A human-readable text summary of the message. In some
     * messaging systems this would map to the "subject" field. //see 3.9.3
     */
    public String getSummary();

    /**
     * The Internet MIME type of the message content. //see 3.9.3
     * @return
     */
    public String getMIMEType(); //see 2.2.3

    /**
     * Access the content of the message.
     * @return
     * @throws MessageReaderException
     */
    public InputStream getContent() throws MessageReaderException; //see 2.1.3, 3.2.3, 3.4.2
}

interface Mailbox{ //see 2.1.8, 2.4.1, 2.7.1

   public static final String NAME_PROPERTY = "mailboxName";

   /**
    * Retrieve all messages available in the mailbox.
    *
   * @return An array of message IDs.
   * @throws MailboxException
   */
   public long[] getAllMessages() throws MailboxException; //see 3.1.3, 3.2.3, 3.3.8, 3.4.2

  /**
   * Retrieve all messages received after the specified message.
   *
   * @param id The message ID.
   * @return An array of message IDs.
   * @throws MailboxException
   */
   public long[] getMessagesSince(long id) throws MailboxException; //see 3.1.3, 3.2.3, 3.3.1, 3.3.8, 3.4.2

   /**
   * Mark the specified messages as read/unread on the back-end
   * messagesource, where supported,e.g.IMAP supports this
   * feature.
   *
   * @param read Whether the specified messages have been read.
   * @param ids An array of messageIDs.
   * @throwsMailboxException
   */
   public void markRead(boolean read, long[] ids) throws MailboxException; //see 3.1.14, 3.3.25

  /**
   * Retrieve the specified messages.
   *
   * @param ids The IDs of the messages to be retrieved.
   * @return Anarray of Messages.
   * @throws MailboxException
   */
  public Message[] getMessages(long[] ids) throws MailboxException; //see 3.1.3, 3.2.3, 3.3.1, 3.3.8, 3.4.2
 }

class MessageReaderException extends Exception { //see 2.1.3, 2.6.2

    private static final long serialVersionUID = 1L; //see 2.3.2

    public MessageReaderException(String message) {
        super(message);
    }

    public MessageReaderException(Throwable cause) {
        super(cause);
    }

    public MessageReaderException(String message, Throwable cause) {
        super(message, cause);
    }
}

class MailboxException extends Exception{ //see 3.4.2, 2.7.1

   private static final long serialVersionUID = 1L; //see 2.3.2

   public MailboxException(String message) {
              super(message);
   }

  public MailboxException(Throwable cause){
             super(cause);
  }

  public MailboxException(String message,Throwable cause){
             super(message,cause);
   }

}


