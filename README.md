# SimulationElection

Simulation d'une élection en JAVA.
Créé par Nathan Puricelli et Aymeric Leto

Comment compiler le projet : 
    Pour compiler le projet, il faut avoir java JDK, qui fournit le programme javac pour compiler le code.
    -Compiler en ligne de commande : 
        -Depuis un terminal : $> javac -d bin src/Personnes/*.java src/Scrutin/*.java src/Dynamique/*.java src/*.java
        -Copier le fichier config.properties dans le dossier bin
    -Compiler avec ant :
        -Installer ant https://ant.apache.org/
        -Depuis un terminal : $> ant

Comment executer le programme :
    Pour executer le programme, il faut déja l'avoir compilé.
    Ensuite , depuis un terminal : $> java -cp bin Main

Comment générer la javadoc : 
    -Avec ant (https://ant.apache.org/) : 
        -Depuis un terminal : $> ant documentation
    -Sans ant :
        -Depuis un terminal à la racine du projet : $>javadoc -d doc - sourcepath src/*.java src/Personnes/*.java src/Scrutin/*.java src/Dynamique/*.java

Lien du projet sur la forge Lyon1 : https://forge.univ-lyon1.fr/p1907453/simulationelection