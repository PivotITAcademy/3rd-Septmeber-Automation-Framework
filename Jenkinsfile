pipeline {
    agent {
        label 'Slave-1'
    }

    stages {
        
             stage('Clean') {
            steps {
                echo'Cleaning workspace....'
               bat "mvn clean"
            }
        
    }
        
        stage('Git Checkout') {
            steps {
                 echo'Cloning Repo from Github'
               git url: 'https://github.com/PivotITAcademy/3rd-Septmeber-Automation-Framework.git'
            }
        
    }
    
        stage('Test') {
            steps {
                echo'Testing....'
               bat "mvn test"
            }
        
    }
    
               stage('Publish Result') {
            steps {
                echo'Result....'
               testNG showFailedBuilds: true
            }
        
    }
    
    
    
            stage('Install') {
            steps {
                echo'Installing....'
               bat "mvn install -DskipTests=true"
            }
        
    }
}

post{
    success{
        echo 'Generating Artifact'
        archiveArtifacts artifacts: 'target/*.jar', caseSensitive: false, defaultExcludes: false, followSymlinks: false, onlyIfSuccessful: true
    }
    failure{
        echo 'Build Fail'
        cleanWs()
    }
    always{
        echo 'Send Email'
    }
}
}
