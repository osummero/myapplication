package swu.pjm.myapplication

import android.animation.Animator
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
/*
Activity用来管理界面的生命周期 和 交互
具体的界面需要自己配置 res -> layout -> .xml(标记文件）
通过setContentView来关联layout布局文件和Java/Kotlin代码
MainActivity(管理交互）activity_main.xml(具体布局）
所有的资源文件都会有一个ID和他对应 要访问这些资源
R.layout.activity_main
R.drawable.1.png
R(系统创建的类，来为我们管理这些资源，为他们一一分配id）
一个activity对应一个界面
 */
        setContentView(R.layout.activity_main)

        //监听按钮被点击的事件
       // mLoginBtn.setOnClickListener(this)//更适用于多个按钮被点击
       /* mLoginBtn.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                println("2.按钮被点击了！")
            }

        })*/
     /*  mLoginBtn.setOnClickListener({view: View? ->
           println("3.按钮被点击了！")
       })
        mLoginBtn.setOnClickListener(){view: View? ->
            println("4.按钮被点击了！")
        }*/
       /* mLoginBtn.setOnClickListener {
            //apply also with run
            ObjectAnimator.ofFloat(mHeader, "rotation", 0f, 360f).also {
                it.duration = 100
                it.repeatCount = 20
                it.start()
                //监听动画的结束事件
                it.addListener(object : Animator.AnimatorListener {
                    override fun onAnimationRepeat(animation: Animator?) {

                    }

                    override fun onAnimationEnd(animation: Animator?) {
                        //界面跳转
                        startActivity(Intent(this@MainActivity, DetailActivity::class.java))
                    }

                    override fun onAnimationCancel(animation: Animator?) {

                    }

                    override fun onAnimationStart(animation: Animator?) {

                    }

                })

            }
        }*/
            //apply 直接在对象内部使用代码块 可以访问这个对象本身的属性和方法
            ObjectAnimator.ofFloat(mHeader,"rotation",0f,360f).apply {
               duration=100
                repeatCount=6
                start()
                addListener(object : MyAnimatorListener() {
                    override fun onAnimationEnd(animation: Animator?) {
                        //界面跳转
                        startActivity(Intent(this@MainActivity,DetailActivity::class.java))
                    }
                })
            }
            /*
            //添加旋转动画 动画结束之后再跳转到下一个界面
            //属性动画 旋转 平移 缩放 透明度
            val anim = ObjectAnimator.ofFloat(mHeader,"rotation",0f,360f)
            anim.duration=100
            anim.repeatCount=20
            anim.start()

          //监听动画的结束事件
            anim.addListener(object :Animator.AnimatorListener{
                override fun onAnimationRepeat(animation: Animator?) {

                }

                override fun onAnimationEnd(animation: Animator?) {
                    //界面跳转
                    startActivity(Intent(this@MainActivity,DetailActivity::class.java))
                }

                override fun onAnimationCancel(animation: Animator?) {

                }

                override fun onAnimationStart(animation: Animator?) {

                }

            })
             */
            //界面跳转
            //startActivity(Intent(this,DetailActivity::class.java))

}

    override fun onClick(v: View?) {
        println("1.按钮被点击了")
    }
}



