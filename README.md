**Fabrick - Problem to be solved**

**Background:**

Realizzare un applicativo che permetta di gestire le seguenti operazioni sul conto:
* Lettura saldo;
* Bonifico

L’applicativo dovrà essere sviluppato utilizzando le API esposte da Platfr.io, la documentazione è disponibile online `https://wFabrickww.platfr.io/#/docs`.
Per la fase di sviluppo e test sarà sufficiente l’utilizzo della versione MOCK della API, non sono necessarie credenziali particolari per l’accesso. Si tratta quindi di utilizzare l’ambiente free beta.

Proprietà/Costanti applicativo
* {accountId} : Long, è il numero conto di riferimento, nelle API è sempre indicato come {accountId}

Operazione: Lettura saldo

* API: https://www.platfr.io/#/docs/api#Account%20Balance
* Input: {accountId}:Long è un parametro dell’applicazione;

Output: Visualizzare il saldo

Operazione: Bonifico
	API: https://www.platfr.io/#/docs/api#Create%20SCT%20Order
Input:
*	{accountId}:Long è un parametro dell’applicazione;
*	{receiverName}:String, è il beneficiario del bonifico;
*	{description}: String, descrizione del bonifico
*	{currency}:String
*	{amount}:String 
*	{executionDate}:String DD/MM/YYYY

Output: Stato dell’operazione;

Non è necessario lo sviluppo di un interfaccia utente;



# M. Biancalani comments
* accountId sul testo dell'esercizio e' riportato come Long, mentre sul sito `https://www.platfr.io/#/docs/api#GET-BankingAccountBalance40` e' una stringa
* Account Balance date e' del format `YYYY-MM-dd`, mentre sul sito `https://www.platfr.io/#/docs/api#GET-BankingAccountBalance40` e' `dd/MM/YYYY`
### Compiling and packaging
`mvn clean package -DskipTests`

### Unit tests
`mvn verify`

### Integration tests
`mvn -P integration,testUnitDisabled verify`

### Run Application

`java -jar app/target/app-1.0-SNAPSHOT-exec.jar`


### Manually test some endpoints
Application Index
`http://localhost:8080/app`


### Run with docker 

create docker image
`cd app && mvn docker:build`

run container
`docker run -p 8080:8080  com.biancama/busyflights`

### Cose che avrei voluto fare ma non ho avuto tempo
* Make json request lowercase
* Passing a json object as request (I didn't do it because for test sake it's easier write URL in README file)
* Improve error handling. For example if date are not with correct format
* Decouple Busy flights endpoint with supplier. In case Of A new supplier I want to change as less as possible the code
* Check availability for number of passengers
* Create an end point to return all possible paths from one departure airport to an arrival departure, according with date constraints.
I thought abaout and the only one I could think it had O(n!) complexity. Maybe it exists a better one 