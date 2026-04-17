package edu.cmu.DirManager;

// API Design Fix: Replaced error return codes (0, -1, -2) with exceptions.
// Using exceptions is the standard Java practice for error handling and provides clearer intent to callers.
public class Manager {
    private DirOps dirOps;
    
    /**
     * Creates a new directory at the specified path.
     *
     * @param path the path where the new directory should be created
     * @throws IllegalArgumentException if the directory already exists
     * @throws IllegalArgumentException if the path is invalid
     */
    public void newDirectory(String path) {
        if (dirOps.checkDirectoryExists(path)) {
            throw new IllegalArgumentException("Directory already exists at path: " + path);
        } else if (!dirOps.checkPathValid(path)) {
            throw new IllegalArgumentException("Path is invalid: " + path);
        } else {
            dirOps.createDirectory(path);
        }
    }
}
