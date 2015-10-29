/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: D:\\works\\Readother\\src\\org\\hydl\\chaper9\\IPet.aidl
 */
package org.hydl.chaper9;
public interface IPet extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements org.hydl.chaper9.IPet
{
private static final java.lang.String DESCRIPTOR = "org.hydl.chaper9.IPet";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an org.hydl.chaper9.IPet interface,
 * generating a proxy if needed.
 */
public static org.hydl.chaper9.IPet asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof org.hydl.chaper9.IPet))) {
return ((org.hydl.chaper9.IPet)iin);
}
return new org.hydl.chaper9.IPet.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_getPets:
{
data.enforceInterface(DESCRIPTOR);
Person _arg0;
if ((0!=data.readInt())) {
_arg0 = Person.CREATOR.createFromParcel(data);
}
else {
_arg0 = null;
}
java.util.List<Pet> _result = this.getPets(_arg0);
reply.writeNoException();
reply.writeTypedList(_result);
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements org.hydl.chaper9.IPet
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
// 定义一个Person对象作为传入参数

@Override public java.util.List<Pet> getPets(Person owner) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.util.List<Pet> _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
if ((owner!=null)) {
_data.writeInt(1);
owner.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_getPets, _data, _reply, 0);
_reply.readException();
_result = _reply.createTypedArrayList(Pet.CREATOR);
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
}
static final int TRANSACTION_getPets = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
}
// 定义一个Person对象作为传入参数

public java.util.List<Pet> getPets(Person owner) throws android.os.RemoteException;
}
