package com.ashwin.android.constraintlayoutdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_barrier.*

class BarrierActivity : AppCompatActivity() {
    val s1 = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum."
    val s2 = "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like)."
    val s3 = "There are many variations of passages of Lorem Ipsum available, but the majority have suffered alteration in some form, by injected humour, or randomised words which don't look even slightly believable. If you are going to use a passage of Lorem Ipsum, you need to be sure there isn't anything embarrassing hidden in the middle of text. All the Lorem Ipsum generators on the Internet tend to repeat predefined chunks as necessary, making this the first true generator on the Internet. It uses a dictionary of over 200 Latin words, combined with a handful of model sentence structures, to generate Lorem Ipsum which looks reasonable. The generated Lorem Ipsum is therefore always free from repetition, injected humour, or non-characteristic words etc."
    val s4 = "Suspendisse eget elit tellus, massa eu amet luctus, aliquet ante varius posuere mus per, quisque arcu aenean elementum quisque amet tristique. Metus molestie, imperdiet lectus amet velit pede ipsum felis, nisl quis mattis aliquam nisl, dapibus nulla ac mauris ad est tristique, odio leo faucibus facilisis. Quis turpis vulputate sed parturient ipsum lacinia. Per in aliquam nulla maecenas elementum condimentum, eu erat augue luctus ac tincidunt. Lectus et donec, hac molestie id vel. Wisi non proin non, quisque pede nisl velit nulla ac integer, dolor porttitor, nostra nonummy donec ac, scelerisque praesent class eget."
    val s5 = "Ac ante sit consectetuer eget proin vestibulum, pede adipiscing arcu est vestibulum quisque. Arcu magna semper morbi condimentum, a aliquam vestibulum, euismod lacus sit aperiam, lectus et diam nunc mauris. Et risus tempus ante augue ultrices diam, ut id elit. Porttitor vestibulum in varius ac sed, vitae quisque ligula neque elit cursus, mi ut, fusce nunc scelerisque venenatis quis sed vestibulum, id placerat viverra. Porttitor morbi maecenas vestibulum, morbi sit, maecenas magna vestibulum curae. Scelerisque sem. Quis mus eget erat mauris sed viverra, neque justo, eu lorem metus maecenas eros vitae et, sit dapibus ullamcorper enim, class quis id porttitor ultrices nam amet. Odio morbi sed ante quis eget."

    val t1 = "Initial Title"
    val t2 = "Small Title"
    val t3 = "Lorem Ipsum Dummy Title"
    val t4 = "Omg Very Very Long Length Title"
    val t5 = "Medium Length Title"

    val titles = arrayOf(t1, t2, t3, t4, t5)
    val contents: Array<String> = arrayOf(s1, s2, s3, s4, s5)

    var i: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_barrier)

        loadContent()
    }

    fun reloadContent(view: View) {
        loadContent()
    }

    private fun loadContent() {
        content_textview.text = contents[i]
        title_textview.text = titles[i]
        i = (++i) % contents.size
    }
}
