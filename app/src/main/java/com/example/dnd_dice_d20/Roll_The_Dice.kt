package com.example.dnd_dice_d20

import android.media.AudioManager
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random
import kotlin.random.nextInt

class Roll_The_Dice : AppCompatActivity() {
    private var SpeedCount = 0
    private var money = 0
    private var soundPool: SoundPool? = null
    private var soundId1: Int = 0

    fun Speedometer(it: View, spid: Int, action: Int)
    {
        when(action){
            1 -> {
                SpeedCount = SpeedCount/100000 + spid
                speed.text = SpeedCount!!.toString() + "коп/секунду"
            }
            2 -> {
                SpeedCount = SpeedCount - spid
                speed.text = SpeedCount!!.toString() + "коп/секунду"



            }
        }

    }

    fun playSound(sound: Int) {
        var soundId = 0
        when (sound) {
            1 -> soundId = soundId1
            else -> print("Error!")
        }
        soundPool?.play(soundId, 1F, 1F, 0, 0, 1F)


    }

    fun balance(){
        while (1 == 1){
            money = money + SpeedCount
            balance.text = money!!.toString()
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        soundPool = SoundPool(1, AudioManager.STREAM_MUSIC, 0)
        soundId1 = soundPool!!.load(baseContext, R.raw.lebovsky, 1)

        balance()
        findViewById<ImageView>(R.id.dnd_dice).setOnClickListener {

            MainScope().launch {

                var RandomNumber = Random.nextInt(1..6)
                var RotateDirection = arrayListOf(-1, 1).random()
                var Rotate_OX_OY = Random.nextBoolean()
                var RotationTime = (5L..10L).random()
                var RotationX = 0F
                var RotationY = 0F
                var Rotation_value = arrayListOf(120, 150, 180, 210, 240).random()

                Speedometer(it, Rotation_value/10, 1)


                for (i in 1..4) {

                    RandomNumber = Random.nextInt(1..6)
                    RotateDirection = arrayListOf(-1, 1).random()
                    Rotate_OX_OY = Random.nextBoolean()


//                    for(i in 0..29)
//                    {
//                        it.rotation =  it.rotation+1
//                        delay(1)
//                    }

                    for (i in 0..29) {
                        if (Rotate_OX_OY) {
                            it.rotationX = it.rotationX + RotateDirection * 3
                            it.rotation = it.rotation + Rotation_value / 30
                            delay(RotationTime)
                            RotationX++
                        } else {
                            it.rotationY = it.rotationY + RotateDirection * 3
                            it.rotation = it.rotation + Rotation_value / 30
                            delay(RotationTime)
                            RotationY++
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
                            else -> R.drawable.ic_launcher_foreground
                        }
                    )


                    for (i in 30..59) {
                        if (Rotate_OX_OY) {

                            it.rotationX = it.rotationX + RotateDirection * 3
                            it.rotation = it.rotation + Rotation_value / 30
                            delay(RotationTime)
                            RotationX++
                        } else {
                            it.rotationY = it.rotationY + RotateDirection * 3
                            it.rotation = it.rotation + Rotation_value / 30
                            delay(RotationTime)
                            RotationY++
                        }
                    }
                    //конец цикла вращений(4раза)




                    rotationX.text = RotationX.toString()
                    rotationY.text = RotationY.toString()


                    //
                }
                Speedometer(it, Rotation_value/10, 2)

                if(SpeedCount < 0){
                    playSound(1)
                }
                //цикл открутки
//                if (RotationX.toInt() == 540) {
//                    for (i in 1..180) {
//                        it.rotationX = it.rotationX - 1
//                        delay(RotationTime)
//                    }
//                }


            }
        }

    }
}