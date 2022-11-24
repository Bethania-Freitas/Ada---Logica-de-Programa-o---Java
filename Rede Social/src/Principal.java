import java.util.Scanner;

public class Principal {
	static Scanner sc = new Scanner(System.in);
	static final int TAM = 10;
	static Usuarios[] perfis = new Usuarios[TAM];
	static Postagens[] post = new Postagens[TAM];
	static int quantPost = 0;
	static int quantUsuarios = 0;
	static int login = 0;

	public static void main(String[] args) {
		System.out.println("       __         .' '.");
		System.out.println("     _/__)        .   .       .");
		System.out.println("    (8|)_}}- .      .        .");
		System.out.println("     `\\__)    '. . ' ' .  . '");
		System.out.println();
		System.out.println("   **** 🐝 Bee 🐝 ****  ");
		System.out.println("**** Sua rede social ****");
		System.out.println();
		menuInicial();
		sc.close();
	}

	static void menuInicial() {
		try {
			System.out.println("»»————-　MENU INICIAL　————-««");
			System.out.println("Digite:");
			System.out.println("1 - para Cadastrar");
			System.out.println("2 - para Login");
			System.out.println("3 - para Fechar");
			login = sc.nextInt();
			switch (login) {
			case 1:
				cadastrar();
				menuInicial();
				break;
			case 2:
				login();
				break;
			case 3:
				sair();
				break;
			default:
				System.out.println("Ops....le denovo ai!! ");
				System.out.println();
				menuInicial();
			}
		} catch (java.util.InputMismatchException e) {
			System.out.println("--- Ta pichuruco?? Da onde tirou isso? ---");
			erro();			
		} catch (Exception e) {
			erro();
		}
	}

	private static void login() {
		listaUsuarios();
		if (quantUsuarios == 0) {
			System.out.println("Você nem fez seu cadastro ainda, criatura!");
			erro();
			System.out.println();
			menuInicial();
		}
		System.out.println("---- LOGIN -----");
		System.out.println("Login: ");
		String login = sc.next().toUpperCase();
		System.out.println("Senha: ");
		String senha = sc.next();		
		for (int i = 0; i < quantUsuarios; i++) {
			if (perfis[i].login.equals(login) && perfis[i].senha.equals(senha)) {
				System.out.println();
				System.out.println("Ola, " + perfis[i].nome + " !");
				System.out.println("╭════════════════════🐝═╮");
				System.out.println("  Bem vindo/a rede BEE!");
				System.out.println("╰═🐝════════════════════╯");
				menuUsuario();
				break;
			} else {
				System.out.println("Prestenção! Login ou senha errados!!.");
				erro();
				menuInicial();
			}
		}
	}

	private static void menuUsuario() {
		try {
			System.out.println();
			System.out.println("----- MENU DO USUÁRIO -----");
			System.out.println("digite 1 - para Postar");
			System.out.println("digite 2 - para Timeline");
			System.out.println("digite 3 - para Sair");
			int opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				postar();
				menuUsuario();
				break;
			case 2:
				timeline();
				break;
			case 3:
				sair();
			default:
				System.out.println("Le direito isso ai!! Não tem esta opção!");
				menuUsuario();
			}
		} catch (Exception e) {
			System.out.println("Ta birulei? Se atente!!!");
			erro();
		}
	}

	static void timeline() {
		System.out.println();
		System.out.println("----- TIMELINE DO USUÁRIO -----");
		for (int i = 0; i < quantPost; i++) {
			System.out.printf("%s às %s - '%s'\n", post[i].data, post[i].hora, post[i].conteúdo);
		}
		menuUsuario();
	}

	static void postar() {
		Postagens a = new Postagens();
		System.out.println();
		System.out.println("----- POSTAR -----");
		System.out.printf("Data: ");
		a.data = sc.next();
		System.out.printf("Hora: ");
		a.hora = sc.next();
		System.out.printf("Mensagem: ");
		sc.nextLine();
		a.conteúdo = sc.nextLine();
		while (a.data.isEmpty() | a.hora.isEmpty() | a.conteúdo.isEmpty()) {
			System.out.println("Todos os campos precisam ser preenchidos");
			return;
		}
		System.out.println();
		System.out.println("Postando..");
		System.out.println("[][][][][][] - 0%");
		System.out.println("[][][]▐▌▐▌▐▌ - 50%");
		System.out.println("▐▌▐▌▐▌▐▌▐▌▐▌ - 100%");
		System.out.println("Publicação registrada com sucesso!!");		
		post[quantPost] = a;
		quantPost++;
	}

	static void cadastrar() {
		Usuarios a = new Usuarios();
		System.out.println("---- NOVO USUÁRIO -----");
		System.out.println("Digite seu nome para cadastrar:");
		sc.nextLine();
		a.nome = sc.nextLine();
		System.out.println("Digite seu login para cadastrar:");
		a.login = sc.next().toUpperCase();
		for (int i = 0; i < quantUsuarios; i++) {
			while (a.login.equals(perfis[i].login)) {
				System.out.println("Login já existe no sistema, tentar novamente");
				return;
			}
		}
		System.out.println("Digite sua senha: ");
		a.senha = sc.next();
		while (a.nome.isEmpty() | a.login.isEmpty() | a.senha.isEmpty()) {
			System.out.println("Nome, login ou senha não foram registrados, tente novamente");
			return;
		}
		System.out.println("Cadastro realizado com sucesso!");
		System.out.println();
		perfis[quantUsuarios] = a;
		quantUsuarios++;
	}

	private static void sair() {
		System.out.println();
		System.out.println("|￣￣￣￣￣￣￣| ");
		System.out.println("| Volta logo! |");
		System.out.println("|＿＿＿＿＿ _＿|");
		System.out.println("()_() ||");
		System.out.println("(•ㅅ•) || ");
		System.out.println("/ 　 づ");
		System.out.println();
		menuInicial();
		
	}

	static void erro() {
		System.out.println("░░░░░░░░░░░░░▄▄▄▄▄▄▄░░░░░░░░░");
		System.out.println("░░░░░░░░░▄▀▀▀░░░░░░░▀▄░░░░░░░");
		System.out.println("░░░░░░░▄▀░░░░░░░░░░░░▀▄░░░░░░");
		System.out.println("░░░░░░▄▀░░░░░░░░░░▄▀▀▄▀▄░░░░░");
		System.out.println("░░░░▄▀░░░░░░░░░░▄▀░░██▄▀▄░░░░");
		System.out.println("░░░▄▀░░▄▀▀▀▄░░░░█░░░▀▀░█▀▄░░░");
		System.out.println("░░░█░░█▄▄░░░█░░░▀▄░░░░░▐░█░░░");
		System.out.println("░░▐▌░░█▀▀░░▄▀░░░░░▀▄▄▄▄▀░░█░░");
		System.out.println("░░▐▌░░█░░░▄▀░░░░░░░░░░░░░░█░░");
		System.out.println("░░▐▌░░░▀▀▀░░░░░░░░░░░░░░░░▐▌░");
		System.out.println("░░▐▌░░░░░░░░░░░░░░░▄░░░░░░▐▌░");
		System.out.println("░░▐▌░░░░░░░░░▄░░░░░█░░░░░░▐▌░");
		System.out.println("░░░█░░░░░░░░░▀█▄░░▄█░░░░░░▐▌░");
		System.out.println("░░░▐▌░░░░░░░░░░▀▀▀▀░░░░░░░▐▌░");
		System.out.println("░░░░█░░░░░░░░░░░░░░░░░░░░░█░░");
		System.out.println("░░░░▐▌▀▄░░░░░░░░░░░░░░░░░▐▌░░");
		System.out.println("░░░░░█░░▀░░░░░░░░░░░░░░░░▀░░░");
	}
	
	static void listaUsuarios() {
		for(int i = 0; i < quantUsuarios; i++) {
			Usuarios perfil = perfis[i];
			System.out.println(perfil.nome);
			System.out.println(perfil.login);
			System.out.println(perfil.senha);
			System.out.println();
		}
	}
	
}
