import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.npm
import jetbrains.buildServer.configs.kotlin.triggers.vcs

version = "2025.03"

project {
    buildType(Build)
    buildType(Lint)

    features {
        // Add project features if needed
    }
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        npm {
            name = "Install Dependencies"
            commands = "install"
            executionMode = BuildStep.ExecutionMode.RUN_IF_FAILED
        }
        npm {
            name = "Build Project"
            commands = "run build"
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

object Lint : BuildType({
    name = "Lint"

    vcs {
        root(DslContext.settingsRoot)
    }

    steps {
        npm {
            name = "Install Dependencies"
            commands = "install"
            executionMode = BuildStep.ExecutionMode.RUN_IF_FAILED
        }
        npm {
            name = "Run Lint"
            commands = "run lint"
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