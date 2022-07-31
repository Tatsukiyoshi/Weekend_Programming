package com.example.demo.component

import org.springframework.stereotype.Component
import java.util.*

@Component
class SampleComponent {
    /** 0～99までの値を生成 */
    public fun random(): Int {
        val random = Random()
        return random.nextInt(100)
    }
}
