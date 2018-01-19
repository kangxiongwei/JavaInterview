# Java序列化和反序列化

# 1.实现Serializable接口

此种情况下，会把整个对象序列化，如果需要阻止某些不序列化，可使用transient阻止

# 2.实现Externalizable接口

重写writeExternal和readExternal，指定哪些序列化，哪些不序列化

案例：

```markdown
@Override
public void writeExternal(ObjectOutput out) throws IOException {
    out.writeObject(name);
    out.writeInt(age);
}

@Override
public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
    name = (String) in.readObject();
    age = in.readInt();
}
```
