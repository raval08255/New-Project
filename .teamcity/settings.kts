import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.exec
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.projectFeatures.githubAppConnection
import jetbrains.buildServer.configs.kotlin.triggers.vcs

version = "2025.03"

project {
    buildType(Build)
    buildType(CustomBuild)

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
            name = "Install Dependencies"
            id = "Install_Dependencies"
            scriptContent = """npm install"""
        }
        script {
            name = "Build Project"
            id = "Build_Project"
            scriptContent = """npm run build"""
        }
        script {
            name = "Lint Code"
            id = "Lint_Code"
            scriptContent = """npm run lint"""
        }
    }

    triggers {
        vcs {
        }
    }
})

object CustomBuild : BuildType({
    name = "name"

    params {
        param("myBuildParameter", "myValue")
    }

    steps {
        script {
            name = "myCommandLineStep"
            scriptContent = "npm install"
        }
    }

    triggers {
        vcs {
            branchFilter = ""
            enableQueueOptimization = false
        }
    }
})
