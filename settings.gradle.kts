dependencyResolutionManagement {
    @Suppress("UnstableApiUsage")
    repositories {
        mavenCentral()
    }
}

rootProject.name = "kretro"

include(":jit-api")
include(":utils")

include(":kstation")
