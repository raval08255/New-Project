import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildFeatures.perfmon
import jetbrains.buildServer.configs.kotlin.buildSteps.exec
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.projectFeatures.githubAppConnection
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

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

    vcsRoot(NewRootID)

    buildType(id)
    buildType(Build)

    features {
        githubAppConnection {
            id = "PROJECT_EXT_2"
            displayName = "TeamCity-08255"
            appId = "1504604"
            clientId = "Iv23liKue8OVdN9WKBvP"
            clientSecret = "zxx3ef734a12aa3f6df06a6b30dc982517ff6dec7f9bde7fda9ea06417c4f42a9db32b97c11365a6b3b775d03cbe80d301b"
            privateKey = "zxx0ead0f89b53aab8c18829126191f80d8f851ffcd3e40676b5c7ef97fc4e4128b87dabfd6760eed78bb3dcb2414a832ecf4373725168e898434a166341596a001073d2a5bf60eeb8d1fbbed8bdbda2c138f79807367140b1a5d70b06c8096ce42dd5cf7b9a569de4546a5dcdfc98ed7630b509647147819f318607609d6c236406d5beaafcbf87db4b921f91e8288df4c58f8690998f1ff827846d565b244710e06d426cc0db67e7ff2af7c618634405996dd92dd9a459f037d2b86d712c6416ea28f149ffa004c3c02312cf6413e7484453ea4475bf8edfe594841b36e1e71a825fd1de0044e2c89b62155480e544b90fe97bb4924ab8df8d57020f370e5d991978670a85ae88ed109d1d633bc93f9de55812668d008476ee9f755b211bb48adb4ab9a876d62582c507b522044763ffe677cce0e6bd4083be53eaeaa0304c101539005a661112682c68fb05926b07f5b059c7ecc2042bb0af28156852f4b316f73487f22b0bb13a2c911c695b575d07c8ffe1c123ca0fd268fae74c37a967dd1f13b1d4a15445ea8b279eb324a2d81e974951a83c32c239a5afbf6ea12858171f9001473eaa98bfc8a65d64d4851599a42a5c713f33dbc09992efeb9f8e22fe88210adb07d1b2bd9323f2f8ffdf53ff7a7c58d2df7afe1a8b259e8513f9059f961a833d3bede3164e81d707bfe261a4c20f7b82ffedb314648740541edc16ff1cc737ba6021aa1621cb389393c0064bf8b0957449ca903dad9b58cbe3373ee41ad60d04326bf4c9a18023b60e0b1399bdc135750cc6d22200af9ada9fa3c2372fbadc04ea640f620a565bbf9dbb7fd31c1e1b5839279518c105c3b85d69bd19568cce856a4b101c923644bc6c6208363c5c418503ba0687b3cd233b0af80946e6f5059581a3ec8f9274fdb953b27e4593858dd79724cb5c729ce9c19e71dc71800b4cfbdff561e68d1ce7a04f7634d5413236ad03bc83803736db149fc3384f13f7a7ed6fdfdbd65869e5899e29495042501d93dac5065ad40c13904786ed57bfb385503bc9190d207e33f3d4466ca92561393826b0771afe2c78887a622044a3132257c697abcd34d46e7cd1af80983ad09a898fb68fbdf05e8280e3a141414a86618e6e8ee58014e376bb66d1626fe0d81713c0596baf27262ba68bd3c3e41dcee10ea524c0343c1d9a47c52e529d203f8c846e2e4e64a0c9df8b810bcef05a804890a11e0b63d4f4cd03eb42891ca6760669b96cb0045f70cae973f23f1014cbdf3db65c48818b805405add5e808a02df6979805a8aceab17bf0b6afd3229330230f201757244a9cd6b101a5cb4ce994e078c91b0cdfb758c52ae41ba2ca88208f7dc3ba3baeac6f389431da2ae4d3f24dd3e7e9d23f6eae7b8508a529dab0e4152a3c6c0fe624d809376eee9c621dda73fad653bc4cad78e08ae285cd59ce9814c5d7036debb09c066601b3bbc895816870d7efeb92048dbbbdb252a5fc65f50d676298a95f41b1db7718ce4020709d7940ce3ea02ba9b336a0e4f0d09a1bbaec2b4d2ccbaf0e7a57bfa99837e7adf35d206b174baa539fee78d21f240e7832cf6413792b584f17737f547fa2e05da8764e83efb4ad1da91161710723ac337937e722fc82fd8d6e7407dc14704f8bbae281947174519109c98d0bcfea222892154101877f38bb2deaa6ddaf6f80b80ff517c81d47ac90f2668acd14468f2987e02223cb928b8ceb4b44e30826ff8cec308944f2b8701e7ea90bc59559ef293c3c4aebbc00b44b3d4bd96799690077272b18964b95dde4edcf25a9056b2cb7d37ce55df5743e50957f50afad17f34002c47f156c6387d4ad252ca2a93ba02644f0cc610bde792697bad6cdca76da34892579b1c5a696f697f5ef7a264c24afd19328ec292d3a4a739aa09ea016db10d63fde0bfa65e2ac8ef98baf90f83f4305fa4816b4a2dad56280329e0f28e685d24c543d19e972232da71237b43291f9487fc97800c55c46f0f7676a61e61f214b35f09e61214f1d65273394deee8c718965b08d2f581d03da1165db9c334d91dbfa28b757e501ff3142c23ca881f256a5e8d6cdd36b9f0ee035f49b35dc49bf88a00b2908534d264df58994e95be404aafd2eabf0257e668a3f1dc518b93da64ce7fb138b8297e98c2fe4ea1b0029eabd0a030a51ef5af73a2dd789b5cb8714f51500e102c3f56b5de51237a7e9801368f53116f2cf213909a0779dc298cd8b7b2cc801b2721f28fe6df7bf9834f7cf4533b5936687ed7019bbbbb7f98824d4424fc767a25b9f635c41b5b6c589cd139b446b2c25e2118ca3f1a3757ffdc43adbd49f82f9825ed7d157997c3495da6bacfabbddf56e21b6bce3e236edfafc6"
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

object NewRootID : GitVcsRoot({
    name = "NewRoot"
    url = "https://github.com/raval08255/New-Project.git"
    branch = "refs/heads/main"
    checkoutSubmodules = GitVcsRoot.CheckoutSubmodules.IGNORE
    checkoutPolicy = GitVcsRoot.AgentCheckoutPolicy.NO_MIRRORS
    authMethod = token {
        tokenId = "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"
    }
})
