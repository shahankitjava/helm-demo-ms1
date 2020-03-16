pipeline {
    libraries { lib 'SharedLibrary@helm-support' }
    
    agent none

    options {
        timestamps()
        timeout(time: 1, unit: 'HOURS')
        buildDiscarder(logRotator(numToKeepStr: '10'))
        //disableConcurrentBuilds()
        //preserveStashes()
    }

    stages {
        stage("Helm") {
            agent {
                            docker {
                                image 'artifacts.aa.com/docker-prod/edots-base:1.0.0'
                                label 'Builder'
                            }
                        }
            steps {
                echo "*****Calling Helm Function*****"
                script {
                    HelmInstall(
                        name: "Hello World!"
                    )
                }
            }
        }
    }
}
