
public class Simulation {
	
	static int numServers;
	static int numClients;
	static int meanServiceTime;
	static int meanInterarrivalTime;
	static SimServer[] servers;
	static Client[] clients;
	static Queue queue [];
	static java.util.Random randomArrival;
	static java.util.Random randomService;
	
	public static void main(String[] args) {
		init(args);
		run(); 
	}
	
	static void init(String[] args) {
		if(args.length < 4) {
			System.out.println("Usage : java Simulation <numServers> "  
					+ "<numClients> <meanServiceTime> <meanInterarrivalTime> ");
			System.out.println(" e.g.: java Simulation 4 1000 20 5");
			System.exit(0);
		}
		
		numServers = Integer.parseInt(args[0]);
		numClients = Integer.parseInt(args[1]);
		meanServiceTime = Integer.parseInt(args[2]);
		meanInterarrivalTime = Integer.parseInt(args[3]);
		
		servers = new SimServer[numServers];
		clients = new Client[numClients];
		randomService = new ExponentialRandom(meanServiceTime);
		randomArrival = new ExponentialRandom(meanInterarrivalTime);
		
		queue = new Queue[numServers];
		
		for(int j=0; j<numServers; j++) {
			queue[j] = new SLinkedQueue();
		}
		
		for(int j=0; j<numServers; j++) {
			servers[j] = new SimServer(j, randomService.nextInt());		
		}
		
		
		System.out.println("	Number of servers = " + numServers);
		System.out.println("	Number of clients = " + numClients);
		System.out.println("	Mean service time = " + meanServiceTime);
		System.out.println("	Mean interarrival time = " + meanInterarrivalTime);
		
		for(int j=0; j<numServers; j++) {		
			System.out.println("Mean service time for " + servers[j] + "=" + servers[j].getMeanServiceTime());
		}
	}

	static void run() {
		int arrivalTime = randomArrival.nextInt();
		int i =0;
		int[] sumTime = new int[numServers];
		int[] serverNum = new int[numServers];
		int lastServingTime = 0;
		
		for(int t = 0; ; t++) { 

			if(t == arrivalTime && i < numClients) { 
				Client client = clients[i++] = new SimClient(i, t);
				queue[i % numServers].add(client); 
				arrivalTime += randomArrival.nextInt(); 
			}
			for(int j = 0; j < numServers; j++) { 
				Server server = servers[j];
				if(t == server.getStopTime()) {
					server.stopServing(t); 
				}
				if(server.isIdle() && !queue[j].empty()) { 
					Client client = (SimClient) queue[j].remove(); 
					server.startServing(client, t);
					sumTime[j] += (server.getStopTime() - t); 
					serverNum[j]++; 
					if(server.getStopTime() > lastServingTime) lastServingTime = server.getStopTime();
				}
			}
			if(t == lastServingTime && i == numClients) break; 
		}
		for(int j=0; j<numServers; j++) {
			System.out.println("Generated Mean service time for " + servers[j] + "=" + servers[j].getMeanServiceTime());
		}
		for(int j=0; j<numServers; j++) {
			System.out.println("Calcualted Mean service time of Server " + (char)('A' + j)  + ": "+ ((double) sumTime[j] / serverNum[j]));
		}
	}
}
