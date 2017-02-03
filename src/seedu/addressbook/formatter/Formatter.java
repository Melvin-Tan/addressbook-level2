package seedu.addressbook.formatter;

import static seedu.addressbook.common.Messages.*;

import java.util.List;

/**
 * Formatter for TextUi to show texts to user.
 */
public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    private static final String COMMENT_LINE_FORMAT_REGEX = "#.*";
    
    public String getLinePrefix() {
    	return LINE_PREFIX;
    }
    
    public String getDivider() {
    	return DIVIDER;
    }

    /**
     * Returns true if the user input line should be ignored.
     * Input should be ignored if it is parsed as a comment, is only whitespace, or is empty.
     *
     * @param rawInputLine full raw user input line.
     * @return true if the entire user input line should be ignored.
     */
    public boolean shouldIgnore(String rawInputLine) {
        return rawInputLine.trim().isEmpty() || isCommentLine(rawInputLine);
    }

    /**
     * Returns true if the user input line is a comment line.
     *
     * @param rawInputLine full raw user input line.
     * @return true if input line is a comment.
     */
    public boolean isCommentLine(String rawInputLine) {
        return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
    }
    
    /**
     * Returns formatted line given a message.
     * 
     * @param message to be shown to user
     */
    public String getFormattedLine(String message) {
    	return LINE_PREFIX + message.replace("\n", LS + LINE_PREFIX);
    }
    
    /** Formats a list of strings as a viewable indexed list. */
    public String getIndexedListForViewing(List<String> listItems) {
        final StringBuilder formatted = new StringBuilder();
        int displayIndex = 1;
        for (String listItem : listItems) {
            formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
            displayIndex++;
        }
        return formatted.toString();
    }
    
    /**
     * Formats a string as a viewable indexed list item.
     *
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }
    
    /**
     * Formats a welcome message based on its version and storage file path.
     *
     * @param version, storageFilePath
     */
    public String[] getWelcomeMessage(String version, String storageFilePath) {
    	String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
    	String[] welcomeMessage = {
    			DIVIDER,
                DIVIDER,
                MESSAGE_WELCOME,
                version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                storageFileInfo,
                DIVIDER
    	};
    	return welcomeMessage;
    }
    
    /** Formats a goodbye message. */
    public String[] getGoodbyeMessage() {
    	String[] goodbyeMessage = {
    			MESSAGE_GOODBYE,
    			DIVIDER,
    			DIVIDER
    	};
    	return goodbyeMessage;
    }
    
    /** Formats an initiation failed message. */
    public String[] getInitFailedMessage() {
    	String[] initFailedMessage = {
    			MESSAGE_INIT_FAILED, 
    			DIVIDER, 
    			DIVIDER
    	};
    	return initFailedMessage;
    }
}