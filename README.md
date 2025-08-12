# Spring Boot RAG Application with Ollama Phi Model & Redis

## 📌 Overview
This project is a **Spring Boot application** integrated with the **Ollama Phi model** for AI responses, using **Retrieval-Augmented Generation (RAG)** to ensure responses are generated **only from custom-trained data**.  
It uses **Redis** as a cache layer to optimize performance and reduce response times.

---

## 🚀 Features
- **Ollama Phi Model** integration (runs locally)
- **RAG** setup for training on custom data
- **Redis** caching via Docker
- **Spring Boot** backend for API exposure
- **Custom Data Restriction** — responses only come from the provided dataset

---

## 📂 Prerequisites
Before running this project, make sure you have:

1. **Java 17+**  
2. **Maven** (for building Spring Boot application)  
3. **Docker** (for Redis container)  
4. **Ollama** installed locally  
5. **Phi model** downloaded in Ollama

---

## 🛠 Installation & Setup

### 1️⃣ Install Ollama Locally
Follow the instructions from the official Ollama website:  
[https://ollama.com/download](https://ollama.com/download)  

Once installed, pull the **Phi model**:
```bash
ollama pull phi
