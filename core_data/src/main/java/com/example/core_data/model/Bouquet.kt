package com.example.core_data.model


class Bouquet private constructor(builder: Builder){
    val id:Int
    val flavors: Map<TypeFlavor, Int>
    init {
        id = builder._id
        flavors = builder._flavors
    }
    operator fun get(key: TypeFlavor): Int {
        return flavors[key]?:0
    }
    class Builder() {
        var _id = 0
        val _flavors: MutableMap<TypeFlavor, Int> = mutableMapOf(
        )
        fun addId(id:Int): Builder {
            _id = id
            return this
        }
        fun addFlower(typeFlavor: TypeFlavor, count: Int): Builder {
            _flavors[typeFlavor] = count
            return this
        }

        fun addWhiteRoses(count: Int): Builder {
            _flavors[TypeFlavor.WHITE_ROSE] = count
            return this
        }

        fun addRedRose(count: Int): Builder {
            _flavors[TypeFlavor.RED_ROSE] = count
            return this
        }

        fun addLotuses(count: Int): Builder {
            _flavors[TypeFlavor.LOTUS] = count
            return this
        }

        fun addTulips(count: Int): Builder {
            _flavors[TypeFlavor.TULIP] = count
            return this
        }

        fun addCloves(count: Int): Builder {
            _flavors[TypeFlavor.CALVE] = count
            return this
        }

        fun addChamomiles(count: Int): Builder {
            _flavors[TypeFlavor.CHAMOMILE] = count
            return this
        }

        fun addOrchids(count: Int): Builder {
            _flavors[TypeFlavor.ORCHID] = count
            return this
        }

        fun addPeonies(count: Int): Builder {
            _flavors[TypeFlavor.PEONY] = count
            return this
        }

        fun addLilies(count: Int): Builder {
            _flavors[TypeFlavor.LILY] = count
            return this
        }

        fun addHydrangeas(count: Int): Builder {
            _flavors[TypeFlavor.HYDRANGEA] = count
            return this
        }

        fun build(): Bouquet = Bouquet(builder = this)
    }

}