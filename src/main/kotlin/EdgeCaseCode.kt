import kotlinx.atomicfu.*
import kotlin.reflect.KProperty

class EdgeCaseObject {
    private val `owner$delegate` = atomic<ClassFile?>(null)

    var owner: ClassFile
        get() = `owner$delegate`.getValue0(this, null)
        set(value) = `owner$delegate`.setValue0(this, null, value)
}

@Suppress("NOTHING_TO_INLINE")
internal inline fun AtomicRef<ClassFile?>.getValue0(thisRef: Any?, prop: KProperty<*>?): ClassFile {
    return value ?: throw IllegalStateException("this class is not of ClassFile")
}

@Suppress("NOTHING_TO_INLINE")
internal inline fun AtomicRef<ClassFile?>.setValue0(thisRef: Any?, prop: KProperty<*>?, value: ClassFile) {
    if (!compareAndSet(null, value))
        throw IllegalStateException("this class is of ClassFile")
}
