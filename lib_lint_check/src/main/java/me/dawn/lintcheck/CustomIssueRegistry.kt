package me.dawn.lintcheck

import com.android.tools.lint.client.api.IssueRegistry
import com.android.tools.lint.detector.api.CURRENT_API
import com.android.tools.lint.detector.api.Issue

/**
 * @author : LeeZhaoXing
 * @date   : 2021/1/11
 * @desc   :
 */
class CustomIssueRegistry :  IssueRegistry() {

    override val issues: List<Issue>
        get() = listOf(
            SerializableClassDetector.ISSUE
        )

    override val api: Int
        get() = CURRENT_API

}