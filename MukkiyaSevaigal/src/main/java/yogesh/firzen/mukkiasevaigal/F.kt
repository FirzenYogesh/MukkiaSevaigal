package yogesh.firzen.mukkiasevaigal

import java.io.File

/**
 * File Utils
 */
object F {

    fun getExtension(file: File): String {
        return getExtension(file.absolutePath);
    }

    fun getExtension(filename: String): String {
        val afterDot: String = filename.substringAfterLast(".")
        return if (afterDot.contains(File.pathSeparator)) {
            ""
        } else {
            afterDot
        }
    }

    /**
     * Check whether the file is an image or not
     *
     * @param filename file path
     * @return Returns true if the file is an Image
     */
    fun isImage(filename: String): Boolean {
        val ext = getExtension(filename).toLowerCase()
        val extensions = arrayOf("jpg", "jpeg", "png", "bmp", "gif", "ai", "ico", "ps", "svg", "psd", "tif", "tiff")
        return extensions.contains(ext)
    }

    /**
     * Check whether the file is an image or not
     *
     * @param file file
     * @return Returns true if the file is an Image
     */
    fun isImage(file: File): Boolean {
        return isImage(file.absolutePath)
    }

    /**
     * Check whether the file is a video or not
     *
     * @param filename file path
     * @return Returns true if the file is an Video
     */
    fun isVideo(filename: String): Boolean {
        val ext = getExtension(filename).toLowerCase()
        val extensions = arrayOf("swf", "rm", "ogg", "h264", "mkv", "avi", "mp4", "wmw", "3gp", "3g2", "webm", "flv", "vob", "mng", "mov", "qt", "m4v", "mpg", "mpeg", "ts")
        return extensions.contains(ext)
    }

    /**
     * Check whether the file is a video or not
     *
     * @param file file
     * @return Returns true if the file is an Video
     */
    fun isVideo(file: File): Boolean {
        return isVideo(file.absolutePath)
    }

    /**
     * Check whether the file is a audio or not
     *
     * @param filename file
     * @return Returns true if the file is an Audio
     */
    fun isAudio(filename: String): Boolean {
        val ext = getExtension(filename).toLowerCase()
        val extensions = arrayOf("aif", "cda", "wpl", "flac", "mp3", "mid", "midi", "xmf", "mxmf", "rtttl", "rtx", "ota", "imy", "ogg", "wav", "ts", "aac", "mp4", "m4a", "3gp")
        return extensions.contains(ext)
    }

    /**
     * Check whether the file is a audio or not
     *
     * @param file file
     * @return Returns true if the file is an Audio
     */
    fun isAudio(file: File): Boolean {
        return isAudio(file.absolutePath)
    }

    fun isDocument(filename: String): Boolean {
        val ext = getExtension(filename).toLowerCase()
        val extensions = arrayOf("doc", "docx", "odt", "pdf", "rtf", "tex", "txt", "wks", "wps", "wpd")
        return extensions.contains(ext)
    }

    fun isDocument(file: File): Boolean {
        return isDocument(file.absolutePath)
    }

    fun isSpreadsheet(filename: String): Boolean {
        val ext = getExtension(filename).toLowerCase()
        val extensions = arrayOf("xlr", "xls", "xlsx", "ods")
        return extensions.contains(ext)
    }

    fun isSpreadsheet(file: File): Boolean {
        return isSpreadsheet(file.absolutePath)
    }

    fun isPresentation(filename: String): Boolean {
        val ext = getExtension(filename).toLowerCase()
        val extensions = arrayOf("key", "odp", "pps", "ppt", "pptx")
        return extensions.contains(ext)
    }

    fun isPresentation(file: File): Boolean {
        return isPresentation(file.absolutePath)
    }

    fun isCompressed(filename: String): Boolean {
        val ext = getExtension(filename).toLowerCase()
        val extensions = arrayOf("7z", "arj", "deb", "pkg", "rar", "rpm", "tar.gz", "z", "zip")
        return extensions.contains(ext)
    }

    fun isCompressed(file: File): Boolean {
        return isCompressed(file.absolutePath)
    }
}