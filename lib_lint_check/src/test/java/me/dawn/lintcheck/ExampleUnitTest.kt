package me.dawn.lintcheck

import com.android.tools.lint.checks.infrastructure.TestFiles
import com.android.tools.lint.checks.infrastructure.TestLintTask.lint
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@Suppress("UnstableApiUsage")
class ExampleUnitTest {
    @Test
    fun test() {
        lint()
            .allowMissingSdk()
            .files(
                TestFiles.kotlin(
                    """
                       package me.dawn.lintcheck
                       import java.io.Serializable
                       
                       class SerializableBean : Serializable {
                           private var serializableField: InnerSerializableBean? = null
                       }

                       class InnerSerializableBean : Serializable {
                           private var commonBean: CommonBean? = null
                       }

                       class CommonBean{
                           private var s: String = "abc"
                       }
                   """
                )
            )
            .issues(SerializableClassDetector.ISSUE)
            .run()
            .expect(
                "No warnings."
            )
    }
}