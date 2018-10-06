package de.fuchspfoten.mokkit.internal;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * Deletes files.
 */
public final class FileDeleter extends Thread {

    /**
     * Files that are scheduled for deletion.
     */
    private static final List<File> scheduledForDeletion = new LinkedList<>();

    static {
        Runtime.getRuntime().addShutdownHook(new FileDeleter());
    }

    /**
     * Schedules a file for deletion.
     *
     * @param file The file.
     */
    public static void scheduleForDeletion(final File file) {
        scheduledForDeletion.add(file);
    }

    /**
     * Constructor.
     */
    private FileDeleter() {
        super();
    }

    @Override
    public void run() {
        System.err.println("Running scheduled file deletion.");
        for (final File file : scheduledForDeletion) {
            delete(file);
        }
    }

    /**
     * Deletes a file recursively.
     *
     * @param file The file.
     */
    private void delete(final File file) {
        if (!file.exists()) {
            return;
        }

        if (file.isDirectory()) {
            for (final File child : file.listFiles()) {
                delete(child);
            }
        }
        file.delete();
    }
}
