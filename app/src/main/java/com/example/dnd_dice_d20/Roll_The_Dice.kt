package com.example.dnd_dice_d20

import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random
import kotlin.random.nextInt

class Roll_The_Dice : AppCompatActivity() {
    private var SpeedCount = 0
    private var soundPool: SoundPool? = null
    private var soundId1: Int = 0
    private var soundId2: Int = 0
    private var soundId3: Int = 0
    private var soundId4: Int = 0
    private var soundId5: Int = 0
    private var soundId6: Int = 0
    private var soundId7: Int = 0
    private var soundId8: Int = 0
    private var soundId9: Int = 0
    private var soundId10: Int = 0
    private var soundId11: Int = 0
    private var soundId12: Int = 0
    private var soundId13: Int = 0
    private var soundId14: Int = 0
    private var soundId15: Int = 0
    private var soundId16: Int = 0
    private var soundId17: Int = 0
    private var soundId18: Int = 0
    private var soundId19: Int = 0
    private var soundId20: Int = 0


    fun playSound(sound: Int) {
        var soundId = 0
        when (sound) {
            1 -> soundId = soundId1
            2 -> soundId = soundId2
            3 -> soundId = soundId3
            4 -> soundId = soundId4
            5 -> soundId = soundId5
            6 -> soundId = soundId6
            7 -> soundId = soundId7
            8 -> soundId = soundId8
            9 -> soundId = soundId9
            10 -> soundId = soundId10
            11 -> soundId = soundId11
            12 -> soundId = soundId12
            13 -> soundId = soundId13
            14 -> soundId = soundId14
            15 -> soundId = soundId15
            16 -> soundId = soundId16
            17 -> soundId = soundId17
            18 -> soundId = soundId18
            19 -> soundId = soundId19
            20 -> soundId = soundId20
            else -> print("Error!")
        }
        soundPool?.play(soundId, 1F, 1F, 0, 0, 1F)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        soundPool = SoundPool(1, AudioManager.STREAM_MUSIC, 0)
        soundId1 = soundPool!!.load(baseContext, R.raw.one, 1)
        soundId2 = soundPool!!.load(baseContext, R.raw.two, 1)
        soundId3 = soundPool!!.load(baseContext, R.raw.three, 1)
        soundId4 = soundPool!!.load(baseContext, R.raw.four, 1)
        soundId5 = soundPool!!.load(baseContext, R.raw.five, 1)
        soundId6 = soundPool!!.load(baseContext, R.raw.six, 1)
        soundId7 = soundPool!!.load(baseContext, R.raw.seven, 1)
        soundId8 = soundPool!!.load(baseContext, R.raw.eight, 1)
        soundId9 = soundPool!!.load(baseContext, R.raw.nine, 1)
        soundId10 = soundPool!!.load(baseContext, R.raw.ten, 1)
        soundId11 = soundPool!!.load(baseContext, R.raw.eleven, 1)
        soundId12 = soundPool!!.load(baseContext, R.raw.twelve, 1)
        soundId13 = soundPool!!.load(baseContext, R.raw.thirteen, 1)
        soundId14 = soundPool!!.load(baseContext, R.raw.fourteen, 1)
        soundId15 = soundPool!!.load(baseContext, R.raw.fifteen, 1)
        soundId16 = soundPool!!.load(baseContext, R.raw.sixteen, 1)
        soundId17 = soundPool!!.load(baseContext, R.raw.seventeen, 1)
        soundId18 = soundPool!!.load(baseContext, R.raw.eighteen, 1)
        soundId19 = soundPool!!.load(baseContext, R.raw.nineteen, 1)
        soundId20 = soundPool!!.load(baseContext, R.raw.twenty, 1)



        findViewById<ImageView>(R.id.dnd_dice).setOnClickListener {
            MainScope().launch {

                //Блок инициализации

                //Random
                var RandomNumber = Random.nextInt(1..6)
                var RotateDirection = arrayListOf(-1, 1).random()
                var Rotate_OX_OY = Random.nextBoolean()
                var RotationTime = (6L..8L).random()
                var Rotation_value = arrayListOf(120, 150, 180, 210, 240).random()

                //Constant
                var ScaleValue = 0.015F



                for (i in 1..4) {

                    RandomNumber = Random.nextInt(1..20)
                    RotateDirection = arrayListOf(-1, 1).random()
                    Rotate_OX_OY = Random.nextBoolean()

                    for (i in 0..29) {
                        it.scaleX = it.scaleX + ScaleValue
                        it.scaleY = it.scaleY + ScaleValue

                        if (Rotate_OX_OY) {
                            it.rotationX = it.rotationX + RotateDirection * 3
                            it.rotation = it.rotation + Rotation_value / 30
                            delay(RotationTime)
                        } else {
                            it.rotationY = it.rotationY + RotateDirection * 3
                            it.rotation = it.rotation + Rotation_value / 30
                            delay(RotationTime)
                        }
                    }



                    findViewById<ImageView>(R.id.dnd_dice).setImageResource(
                        when (RandomNumber) {
                            1 -> R.drawable.one
                            2 -> R.drawable.two
                            3 -> R.drawable.three
                            4 -> R.drawable.four
                            5 -> R.drawable.five
                            6 -> R.drawable.six
                            7 -> R.drawable.seven
                            8 -> R.drawable.eight
                            9 -> R.drawable.nine
                            10 -> R.drawable.ten
                            11 -> R.drawable.eleven
                            12 -> R.drawable.twelve
                            13 -> R.drawable.thirteen
                            14 -> R.drawable.fourteen
                            15 -> R.drawable.fifteen
                            16 -> R.drawable.sixteen
                            17 -> R.drawable.seventeen
                            18 -> R.drawable.eighteen
                            19 -> R.drawable.nineteen
                            20 -> R.drawable.twenty
                            else -> R.drawable.ic_launcher_foreground
                        }
                    )


                    for (i in 30..59) {
                        it.scaleX = it.scaleX - ScaleValue
                        it.scaleY = it.scaleY - ScaleValue

                        if (Rotate_OX_OY) {

                            it.rotationX = it.rotationX + RotateDirection * 3
                            it.rotation = it.rotation + Rotation_value / 30
                            delay(RotationTime)
                        } else {
                            it.rotationY = it.rotationY + RotateDirection * 3
                            it.rotation = it.rotation + Rotation_value / 30
                            delay(RotationTime)
                        }
                    }
                }

                playSound(RandomNumber)
                for(i in 1..RandomNumber) {
                    Animate_Manul()
                    delay(1500)
                }

            }
        }
    }

    private fun Animate_Manul()
    {
        MainScope().launch {

            for (i in 1..10) {
                (manul_animation.layoutParams as FrameLayout.LayoutParams).leftMargin += 120

                box_animation.removeView(manul_animation)
                box_animation.addView(manul_animation)
                findViewById<ImageView>(R.id.manul_animation).setImageResource(
                    when (i) {
                        1 -> R.drawable.manul_five
                        2 -> R.drawable.manul_two
                        3 -> R.drawable.manul_three
                        4 -> R.drawable.manul_four
                        5 -> R.drawable.manul_five
                        6 -> R.drawable.manul_six
                        7 -> R.drawable.manul_seven
                        8 -> R.drawable.manul_eight
                        9 -> R.drawable.manul_nine
                        10 -> R.drawable.manul_ten
                        else -> R.drawable.ic_launcher_background
                    }
                )
                delay(50)
            }

            (manul_animation.layoutParams as FrameLayout.LayoutParams).leftMargin -= 1200

            box_animation.removeView(manul_animation)
            box_animation.addView(manul_animation)
        }


    }
}