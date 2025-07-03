import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.exec
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.projectFeatures.githubAppConnection
import jetbrains.buildServer.configs.kotlin.triggers.vcs

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2025.03"

project {

    buildType(id)
    buildType(Build)

    features {
        githubAppConnection {
            id = "PROJECT_EXT_2"
            displayName = "TeamCity-08255"
            appId = "1504604"
            clientId = "Iv23liKue8OVdN9WKBvP"
            clientSecret = "credentialsJSON:91987217-92ba-42e0-939f-52b0d3dad4fe"
            privateKey = "credentialsJSON:1cf93df6-0a46-45dc-ac63-0446b678083f"
            ownerUrl = "https://github.com/raval08255"
            useUniqueCallback = true
        }
    }
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        script {
            name = "Say hello"
            id = "Say_hello"
            scriptContent = """echo "hello world""""
        }
    }

    triggers {
        vcs {
        }
    }

    features {
        perfmon {
        }
    }
})

object id : BuildType({
    name = "name"

    params {
        param("myBuildParameter", "myValue")
    }

    steps {
        exec {
            name = "myCommandLineStep"
            param("script.content", "echo 'Hello World!'")
        }
    }

    triggers {
        vcs {
            branchFilter = ""
            enableQueueOptimization = false
        }
    }
})
