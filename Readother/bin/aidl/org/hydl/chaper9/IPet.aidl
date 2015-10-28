package org.hydl.chaper9;

import org.hydl.chaper9.Pet;
import org.hydl.chaper9.Person;


interface IPet
{
	// 定义一个Person对象作为传入参数
	List<Pet> getPets(in Person owner);
}