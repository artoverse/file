https://gemini.google.com/share/dcc9c95a3502

Here’s the list of experiments from **Experiment 4 to Experiment 10** as given in the lab manual, simplified for clarity:

---

### **Experiment List (4 to 10)**  

#### **4. Distance Vector Routing Algorithm**  
   - **Objective**: Implement the Distance Vector Routing algorithm to compute routing tables for each node in a network.  
   - **Key Concepts**: Routing tables, Bellman-Ford algorithm, network topology.  

#### **5. TCP Client-Server Applications**  
   - **a. TCP Iterative Server**: Reverse a given input sentence.  
   - **b. TCP File Transfer**: Transfer files between client and server.  
   - **c. TCP Concurrent Server (Uppercase Converter)**: Convert text to uppercase using `select()`.  
   - **d. TCP Concurrent Server (Echo)**: Echo sentences using `poll()`.  

#### **6. UDP Client-Server Applications**  
   - **a. UDP Sentence Reverser**: Reverse input sentences.  
   - **b. UDP File Transfer**: Transfer files using UDP (no connection guarantees).  

#### **7. Advanced Socket System Calls**  
   - **Objective**: Demonstrate usage of:  
     - `getsockopt()` / `setsockopt()` (socket options).  
     - `getpeername()` / `getsockname()` (address info).  
     - Scattered read (`readv`) / Gathered write (`writev`).  

#### **8. Concurrent Chat Server**  
   - **Objective**: Implement a multi-client chat server where logged-in users can communicate in real-time.  
   - **Key Features**: Threaded clients, broadcast messaging.  

#### **9. DNS Implementation**  
   - **Objective**: Simulate a DNS resolver to map domain names to IP addresses.  
   - **Key Methods**: `InetAddress.getByName()` (Java’s built-in DNS lookup).  

#### **10. Ping Service**  
   - **Objective**: Implement a basic ICMP ping utility to check host reachability.  
   - **Key Methods**: `InetAddress.isReachable()` (Java’s ping simulation).  

---

### **Key Notes**  
1. **Protocols**:  
   - Experiments 4–6 focus on **TCP/UDP** (reliable vs. connectionless).  
   - Experiments 7–10 cover **advanced networking** (sockets, DNS, ICMP).  
2. **Concurrency**:  
   - Experiments 5c/d and 8 use threads or multiplexing (`select`/`poll`) for handling multiple clients.  
3. **Real-World Tools**:  
   - DNS (Exp 9) and Ping (Exp 10) are simplified versions of standard network utilities.  

Let me know if you’d like the code for any specific experiment!