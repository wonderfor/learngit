package org.hydl.chaper9;

import org.hydl.chaper9.Pet;
import org.hydl.chaper9.Person;


interface IPet
{
	// ����һ��Person������Ϊ�������
	List<Pet> getPets(in Person owner);
}