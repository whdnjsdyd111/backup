package é��07_���;

public class ��1_DmbCellPhoneExample {
	public static void main(String[] args) {
		// DmbCellPhone ��ü ����
		��1_DmbCellPhone dmbCellPhone = new ��1_DmbCellPhone("�ڹ���", "����", 10);
		��1_CellPhone cell = new ��1_CellPhone();
		
		// CellPhone���κ��� ��ӹ��� �ʵ�
		System.out.println("��: " + dmbCellPhone.model);
		System.out.println("����: " + dmbCellPhone.color);
		
		// DmbCellPhone�� �ʵ�
		System.out.println("ä��: " + dmbCellPhone.channel);
		
		// CellPhone���κ��� ��ӹ��� �޼ҵ� ����
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("��������");
		dmbCellPhone.receiveVoice("��~");
		dmbCellPhone.sendVoice("�Ƴ�");
		dmbCellPhone.hangUp();
		
		// DmbCellPhone�� �޼ҵ� ȣ��
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelBmb(12);
		dmbCellPhone.turnOffDmb();
		
	}
}
