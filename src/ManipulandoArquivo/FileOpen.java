package ManipulandoArquivo;

	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.IOException;
	import java.util.Scanner;
	 
	public class FileOpen {
	 
		  public static void main(String[] args) {
		        // Escrevendo em um arquivo de texto
		        addFromFile("fileData.txt");	  
		        // Lendo de um arquivo de texto
		        String content = readFromFile("fileData.txt");
		        System.out.println("Código;Nome \n" + content);
		        
		        // Buscar o item no texto       
		        content = searchFromFile("fileData.txt", "Giovanna");
		        if (!content.isEmpty()) {
		        	System.out.println("Código;Nome \n " + content);
		        }else {
		        	System.out.println("Valor não localizado ");
		        }
		        //Atualizar o item no texto do arquivo fileData.txt
		        String contentUpdate = updateFromFile("fileData.txt", "casa","casa nova");
		        if (!content.isEmpty()) {
		        	writeToFile("fileData.txt", contentUpdate);
		        	content = readFromFile("fileData.txt");
		  	        System.out.println("Código;Nome \n" + content);
		        }else {
		        	System.out.println("Valor não localizado ");
		        }
		        
		        String contentDelete = deleteFromFile("fileData.txt", "casa nova");
		        if (!contentDelete.isEmpty()) {
		        	writeToFile("fileData.txt", contentDelete);
		        	content = readFromFile("fileData.txt");
		  	        System.out.println("Código;Nome \n" + content);
		        }else {
		        	System.out.println("Valor não localizado ");
		        }

		    }
	 
		  
		  public static void addFromFile(String fileName) {
				@SuppressWarnings("resource")
				Scanner sc = new Scanner(System.in);
				System.out.println("Digite o código:");
				int id = sc.nextInt();
				System.out.println("____________________________________________");
				System.out.println("Digite o nome:");
				String name = sc.next();   
				String content = id + ";" + name + "\n";
				writeToFile(fileName, content);
		}

		  //função de procedimento que grava a informação no arquivo contéudo lido do arquivo  
		  public static void writeToFile(String fileName, String content) {
		        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))) {
		        	//Escrever o conteúdo no arquivo
		            writer.write(content);
		            System.out.println("Conteúdo escrito no arquivo com sucesso.");
		        } catch (IOException e) {
		            System.err.println("Erro ao escrever no arquivo: " + e.getMessage());
		        }
		    }

		    //função com retorno do contéudo lido do arquivo 
		    public static String readFromFile(String fileName) {
		        StringBuilder content = new StringBuilder();
		        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
		            String line;
		            /*Executar o loop de repetição enquanto a variável lida 
		              no arquivo for diferente de nulo
		            */
		            while ((line = reader.readLine()) != null) {
		            	//escreve o conteúdo na variável 
		                content.append(line).append("\n");
		            }
		        } catch (IOException e) {
		            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
		        }
		        return content.toString();
		    }
		    

		    //função com retorno uma linha especifica do arquivo
		    public static String searchFromFile(String fileName, String search) {
		        StringBuilder content = new StringBuilder();
		        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
		            String line;
		            /*Executar o loop de repetição enquanto a variável lida
		              no arquivo for diferente de nulo
		            */
		            // Ler o arquivo linha por linha e procurar a palavra
		            while ((line = reader.readLine()) != null) {
		                if (line.contains(search)) {
		                    content.append(line).append("\n");
		                }
		            }
		            
		            
		            
		        } catch (IOException e) {
		            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
		        }
		        return content.toString();
		    }
		    public static String updateFromFile(String fileName, String search, String update) {
		        StringBuilder content = new StringBuilder();
		        
		        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
		            String line;
		            String newLine = "";
		            /*Executar o loop de repetição enquanto a variável lida
		              no arquivo for diferente de nulo
		            */
		            // Ler o arquivo linha por linha e procurar a palavra
		            while ((line = reader.readLine()) != null) {
		                	newLine = line.replace(search, update);
		                	content.append(newLine).append("\n");
			       	                
		            }
		            
		        } catch (IOException e) {
		            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
		        }
	            return content.toString();
		        
		    }      
		    
		    public static String deleteFromFile(String fileName, String search) {
		        StringBuilder content = new StringBuilder();
		        
		        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
		            String line;
		            /*Executar o loop de repetição enquanto a variável lida
		              no arquivo for diferente de nulo
		            */
		            // Ler o arquivo linha por linha e procurar a palavra
		            while ((line = reader.readLine()) != null) {
		                if (!line.contains(search)) {
		                	content.append(line).append("\n");
		                }
		            }
		            
		        } catch (IOException e) {
		            System.err.println("Erro ao ler o arquivo: " + e.getMessage());
		        }
	            return content.toString();
		        
		    }
	 

	}


