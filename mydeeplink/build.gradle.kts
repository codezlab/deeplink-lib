import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.vanniktech.maven.publish") version "0.29.0"
}

android {
    namespace = "com.codezlab.mydeeplink"
    compileSdk = 34

    defaultConfig {
        minSdk = 26
        targetSdk = 34
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

mavenPublishing {
            //publishToMavenCentral(SonatypeHost.DEFAULT)
            // or when publishing to https://s01.oss.sonatype.org
            publishToMavenCentral(SonatypeHost.S01)
            // or when publishing to https://central.sonatype.com/
            //publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

            signAllPublications()

}


mavenPublishing {
    coordinates("com.codezlab", "mydeeplink", "1.0.0-SNAPSHOT")

    pom {
        name.set("mydeeplink")
        description.set("A description of what my library does.")
        inceptionYear.set("2024")
        url.set("https://github.com/codezlab/deeplink-lib/")
        licenses {
            license {
                name.set("The Apache License, Version 2.0")
                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                distribution.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
            }
        }

        developers {
            developer {
                id.set("codezlab")
                name.set("Satender Singh")
                url.set("https://github.com/codezlab/")
            }
        }
        scm {
            url.set("https://github.com/codezlab/deeplink-lib/")
            connection.set("scm:git:git://github.com/codezlab/deeplink-lib.git")
            developerConnection.set("scm:git:ssh://git@github.com/codezlab/deeplink-lib.git")
        }
    }
}


/*
publishing {
    publications {

        register<MavenPublication>("release") {
            groupId = "com.codezlab"
            artifactId = "mydeeplink"
            version = "1.0"

            afterEvaluate {
                from(components["release"])
            }
        }


        */
/*create<MavenPublication>("maven") {
            groupId = "com.codezlab"
            artifactId = "mydeeplink"
            version = "0.1-SNAPSHOT"

            //from(components["release"])
        }*//*

        */
/*maven(MavenPublication) {
            groupId = 'com.codezlab'
            artifactId = 'mydeeplink'
            version = "0.1-SNAPSHOT"
            *//*
*/
/*from components.java

                    pom {
                        name = 'My Library'
                        description = 'A description of my library'
                        ...
                    }*//*
*/
/*
        }*//*

    }

    repositories {
        maven {
            name = "mydeeplink"
            url = uri(layout.buildDirectory.dir("repo"))
        }
    }

}

tasks.register<Zip>("generateRepo") {
    val publishTask = tasks.named(
        "publishReleasePublicationToMyrepoRepository",
        PublishToMavenRepository::class.java)
    from(publishTask.map { it.repository.url })
    into("mydeeplink")
    archiveFileName.set("mydeeplink.zip")
}
*/

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
}