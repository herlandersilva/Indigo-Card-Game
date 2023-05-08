data class Box(val height: Int, val length: Int, val width: Int) {
    var size: Int = height + length + width
    override fun toString(): String = "%s(height=%d, width=%d, size=%d)"
        .format(this::class.simpleName, height, width, size)
}