plugins {
    id("buildsrc.convention.kotlin-jvm")
    application
}

dependencies {
    implementation(project(":jit-api"))
    implementation(project(":utils"))
}

application {
    mainClass = "io.github.vbe0201.kretro.kstation.AppKt"
}
