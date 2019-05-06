package com.kw.rcl.design.api.checklist.afterdesign;

/**
 * package overview (package-info.java) for the redesigned API
 * @author kinwey
 * @Date 2019-04-27
 */
public class Package_info {
    /**
     * <p>
     * Provides simple and generic read-only access to messages from a variety
     * of different sources like email, RSS and Atompub feeds, instant messaging
     * services, Facebook, SMS and Twitter.</p> [1.3.3]
     * <p>
     * All concrete classes implement either {@link org.osgi.book.reader.MessageHeader}
     * or {@link org.osgi.book.reader.Mailbox}. Together, these two abstract classes define the
     * generic interface used in the package. All concrete classes are protocol-specific
     * implementations and extensions like {@link org.osgi.book.reader.EmailHeader} or
     * {@link org.osgi.book.reader.ImapMailbox}</p> [1.3.5]
     * <p>
     * Classes from this package are not intended for direct instantiation.
     * They have no public constructors. Instead, pre-configured instances of mailboxes
     * must be retrieved by their name through a JNDI lookup from the naming context
     * "com/env/mailboxes"</p>
     * <p>
     * Classes from this package are not intended for extension. All concrete
     * classes are final and abstract classes have no public or protected constructors.</p>
     * <p>
     * The code sample bellow shows how to read and print out messages
     * from all configured mailboxes: </p> [1.3.6]
     *
     * <pre>
     *     import org.osgi.book.reader.*;
     *     import javax.naming.*;
     *     import java.rmi.RemoteException;
     *
     *     try {
     *         Context initialContext = new InitialContext();
     *         NamingEnumeration mailboxNames = initialContext.list("com/env/mailboxes");
     *         while(mailboxNames.hasMore())
     *         {
     *             NameClassPair pair = (NameClassPair) mailboxNames.next();
     *             Mailbox<?> mailbox = (Mailbox<?>) initialContext.lookup(pair.getName());
     *             for(MessageHeader h : mailbox.readAllMessageHeaders()) {
     *                  System.out.println(h);
     *             }
     *         }
     *     } catch (NamingException e) {
     *         e.printStackTrace();
     *     } catch (RemoteException e) {
     *         e.printStackTrace();
     *     }
     * </pre>
     *
     * @version 2.0 [1.3.10]
     *
     * <br/>
     * <p>This sample API is an adaptation of the original published in
     * <a href="http://njbartlett.name/osgibook.html">"OSGi in Practice"</a> by Neil Bartlett
     *
     * <br/>
     * <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/">
     * <img alt="Creative Commons License" style="border-width:0"
     * src="http://i.creativecommons.org/l/by-sa/3.0/88x31.png" /></a>
     *
     * <br/>
     * Sample API by Neil Bartlett and Ferenc Mihaly is licensed under a
     * <a rel="license" href="http://creativecommons.org/licenses/by-sa/3.0/">
     * Creative Commons Attribution-ShareAlike 3.0 Unported License</a>. [1.3.12]
     */
}
