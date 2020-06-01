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
                        name: "Hello World!",
                        KUBE_CONTEXT_NAME:"3cdf9bdadce442ac9f9abea7a72da7a9",
                        KUBE_CLUSTER_NAME:"3cdf9bdadce442ac9f9abea7a72da7a9",
                        KUBE_NAMESPACE:"helm-test",
                        KUBE_USER: "ankit.shah@aa.com/67eaa4b4b0b80862fab45beb6b22f002",
                        IBM_REGION: "us-south",
                        RESOURCE_GROUP: "BUY-resgrp",
                        API_KEY: "0qJFm2tHzGyqD6KY1FV5QUVS4Tttd1P34V1RitHHx_dQ"
                    )
                }
            }
        }
    }
}
