/*
import kotlinx.atomicfu.*
import kotlin.reflect.KProperty

class OriginalCaseObject {
    var owner: ClassFile by OwnerProperty()
}

// This will make compile the following error: Unsupported operation on atomic variable
// As the workaround, In the original code, I remove OwnerProperty class and replaced
// `INVOKESTATIC OwnerProperty constructor-impl(Lkotlinx/atomicfu/AtomicRef;)Lkotlinx/atomicfu/AtomicRef;` to NOP
// to prevent atomicfu from processing OwnerProperty class.
@JvmInline
internal value class OwnerProperty constructor(val atomic: AtomicRef<ClassFile?>) {
    override fun toString(): String = "OwnerProperty"
}

@Suppress("NOTHING_TO_INLINE")
internal inline fun OwnerProperty() = OwnerProperty(atomic(null))

@Suppress("NOTHING_TO_INLINE")
internal inline operator fun OwnerProperty.getValue(thisRef: Any?, prop: KProperty<*>): ClassFile {
    return atomic.value ?: throw IllegalStateException("this class is not of ClassFile")
}

@Suppress("NOTHING_TO_INLINE")
internal inline operator fun OwnerProperty.setValue(thisRef: Any?, prop: KProperty<*>, value: ClassFile) {
    if (!atomic.compareAndSet(null, value))
        throw IllegalStateException("this class is of ClassFile")
}
// */