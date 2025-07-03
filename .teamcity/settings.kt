import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.python

object Build : BuildType({
    name = "Build"
    // ...
    steps {
        python {
            id = "python_runner"
            command = script {
                content = """print ("Running a Python script...")"""
            }
        }
    }
    // ...
})
