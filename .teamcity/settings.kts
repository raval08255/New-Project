import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.exec
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.projectFeatures.githubAppConnection
import jetbrains.buildServer.configs.kotlin.triggers.vcs

version = "2025.03"

project {
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
    name = "Project Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
    }

    triggers {
        vcs {
        }
    }
})