package Customer;

public interface PublicConstants {
	public static final int MENU_NUM = 8;
	public static final int PRINT_CUSTOMER_LIST = 0;
	public static final int REGISTER_NEW_CUSTOMER = 1;
	public static final int MODIFY_CUSTOMER_INFO = 2;
	public static final int LOOKUP_CUSTOMER_POINT = 3;
	public static final int DELETE_CUSTOMER = 4;
	public static final int LOGIN = 5;
	public static final int EXIT = 6;
	public static final String TITLE = "\\t### Customer Management Program ###\\n";
	public static final String[] MENU = {"## 0. �� ��� ���\n",
										 "## 1. �ű� �� ���\n",
										 "## 2. �� ���� ����\n",
										 "## 3. �� ����Ʈ ��ȸ\n",
										 "## 4. �� ����\n",
										 "## 5. �α���\n",
										 "## 6. ���α׷� ����\n",
										 ">> Input : "}; 
	public static final String INT_MISMATCH_EXCEPT_MSG = "�߸��Է��߽��ϴ�!! ������ �ٽ� �Է����ּ���.";
	public static final String FATAL_ELSE_MSG = "�߻��ϸ� �� �Ǵ� else�� �߻��߽��ϴ�!!";
	public static final String NO_EXIST_CUSTOMER_MSG = "�� ����� �����ϴ�!!";
	public static final String INVALID_CUSTOMER_NO_MSG = "�ش� �� ��ȣ�� �������� �ʽ��ϴ�!! �ٽ� �Է��ϼ���";
	public static final String MODIFY_CUSTOMER_MSG = ">> �����ϰ� ���� ������ �� ��ȣ�� �Է��ϼ��� : ";
	public static final String LOOKUP_CUSTOMER_MSG = ">> ��ȸ�� ���ϴ� ������ �� ��ȣ�� �Է��ϼ��� : ";
	public static final String DELETE_CUSTOMER_MSG = ">> ������ ���ϴ� ������ �� ��ȣ�� �Է��ϼ��� : ";
	public static final String LOGIN_CUSTOMER_MSG = "�α���\n >> ������ ���̵� �Է��ϼ��� (���̵�� ����ȣ): ";
}
