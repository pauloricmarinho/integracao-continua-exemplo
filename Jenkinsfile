pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M2-JENKINS"
    }

    stages {
        stage('Build') {
            steps {
                // Get some code from a GitHub repository
                git 'https://github.com/pauloricmarinho/integracao-continua-exemplo.git'

                // Run Maven on a Unix agent.
                //sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post {
                // If Maven was able to run the tests, even if some of the test
                // failed, record the test results and archive the jar file.
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.war'
                }
            }
        }
        stage('Deploy on Tomcat') {
             steps {
                 deploy adapters: [tomcat8(credentialsId: 'user-tomcat', path: '', url: 'http://localhost:8585')], contextPath: 'app-bootaluno', war: 'target/*.war'
             }
        }
    }
}
