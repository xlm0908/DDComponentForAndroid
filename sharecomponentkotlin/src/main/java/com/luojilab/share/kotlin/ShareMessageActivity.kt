package com.luojilab.share.kotlin

import android.app.Activity
import android.os.Bundle
import com.luojilab.component.componentlib.service.AutowiredService
import com.luojilab.componentservice.share.bean.Author
import com.luojilab.router.facade.annotation.Autowired
import com.luojilab.router.facade.annotation.RouteNode
import kotlinx.android.synthetic.main.kotlin_activity_share.*

/**
 * Created by mrzhang on 2017/12/29.
 */
@RouteNode(path = "/shareMagazine", desc = "分享杂志页面")
class ShareMessageActivity : Activity() {

    @Autowired(name = "bookName")
    @JvmField
    var magazineName: String? = null

    @Autowired
    @JvmField
    var author: Author? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AutowiredService.Factory.getInstance().create().autowire(this)
        setContentView(R.layout.kotlin_activity_share)

        share_title.text = "Magazine"
        share_tv_tag.setText(magazineName)
        share_tv_author.setText(author?.name ?: "zmq")
        share_tv_county.setText(author?.county ?: "China")

    }

}