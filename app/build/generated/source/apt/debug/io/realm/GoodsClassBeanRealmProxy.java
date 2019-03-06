package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class GoodsClassBeanRealmProxy extends com.Realm.entry.GoodsClassBean
    implements RealmObjectProxy, GoodsClassBeanRealmProxyInterface {

    static final class GoodsClassBeanColumnInfo extends ColumnInfo {
        long gidIndex;
        long gNameIndex;
        long numIndex;

        GoodsClassBeanColumnInfo(OsSchemaInfo schemaInfo) {
            super(3);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("GoodsClassBean");
            this.gidIndex = addColumnDetails("gid", objectSchemaInfo);
            this.gNameIndex = addColumnDetails("gName", objectSchemaInfo);
            this.numIndex = addColumnDetails("num", objectSchemaInfo);
        }

        GoodsClassBeanColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new GoodsClassBeanColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final GoodsClassBeanColumnInfo src = (GoodsClassBeanColumnInfo) rawSrc;
            final GoodsClassBeanColumnInfo dst = (GoodsClassBeanColumnInfo) rawDst;
            dst.gidIndex = src.gidIndex;
            dst.gNameIndex = src.gNameIndex;
            dst.numIndex = src.numIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(3);
        fieldNames.add("gid");
        fieldNames.add("gName");
        fieldNames.add("num");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private GoodsClassBeanColumnInfo columnInfo;
    private ProxyState<com.Realm.entry.GoodsClassBean> proxyState;

    GoodsClassBeanRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (GoodsClassBeanColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.Realm.entry.GoodsClassBean>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$gid() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.gidIndex);
    }

    @Override
    public void realmSet$gid(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'gid' cannot be changed after object was created.");
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$gName() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.gNameIndex);
    }

    @Override
    public void realmSet$gName(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.gNameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.gNameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.gNameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.gNameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$num() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.numIndex);
    }

    @Override
    public void realmSet$num(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.numIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.numIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("GoodsClassBean", 3, 0);
        builder.addPersistedProperty("gid", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("gName", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("num", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static GoodsClassBeanColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new GoodsClassBeanColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "GoodsClassBean";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.Realm.entry.GoodsClassBean createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.Realm.entry.GoodsClassBean obj = null;
        if (update) {
            Table table = realm.getTable(com.Realm.entry.GoodsClassBean.class);
            GoodsClassBeanColumnInfo columnInfo = (GoodsClassBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.GoodsClassBean.class);
            long pkColumnIndex = columnInfo.gidIndex;
            long rowIndex = Table.NO_MATCH;
            if (!json.isNull("gid")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("gid"));
            }
            if (rowIndex != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.Realm.entry.GoodsClassBean.class), false, Collections.<String> emptyList());
                    obj = new io.realm.GoodsClassBeanRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("gid")) {
                if (json.isNull("gid")) {
                    obj = (io.realm.GoodsClassBeanRealmProxy) realm.createObjectInternal(com.Realm.entry.GoodsClassBean.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.GoodsClassBeanRealmProxy) realm.createObjectInternal(com.Realm.entry.GoodsClassBean.class, json.getInt("gid"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'gid'.");
            }
        }

        final GoodsClassBeanRealmProxyInterface objProxy = (GoodsClassBeanRealmProxyInterface) obj;
        if (json.has("gName")) {
            if (json.isNull("gName")) {
                objProxy.realmSet$gName(null);
            } else {
                objProxy.realmSet$gName((String) json.getString("gName"));
            }
        }
        if (json.has("num")) {
            if (json.isNull("num")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'num' to null.");
            } else {
                objProxy.realmSet$num((int) json.getInt("num"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.Realm.entry.GoodsClassBean createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final com.Realm.entry.GoodsClassBean obj = new com.Realm.entry.GoodsClassBean();
        final GoodsClassBeanRealmProxyInterface objProxy = (GoodsClassBeanRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("gid")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$gid((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'gid' to null.");
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("gName")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$gName((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$gName(null);
                }
            } else if (name.equals("num")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$num((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'num' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'gid'.");
        }
        return realm.copyToRealm(obj);
    }

    public static com.Realm.entry.GoodsClassBean copyOrUpdate(Realm realm, com.Realm.entry.GoodsClassBean object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.Realm.entry.GoodsClassBean) cachedRealmObject;
        }

        com.Realm.entry.GoodsClassBean realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(com.Realm.entry.GoodsClassBean.class);
            GoodsClassBeanColumnInfo columnInfo = (GoodsClassBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.GoodsClassBean.class);
            long pkColumnIndex = columnInfo.gidIndex;
            long rowIndex = table.findFirstLong(pkColumnIndex, ((GoodsClassBeanRealmProxyInterface) object).realmGet$gid());
            if (rowIndex == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.getSchema().getColumnInfo(com.Realm.entry.GoodsClassBean.class), false, Collections.<String> emptyList());
                    realmObject = new io.realm.GoodsClassBeanRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, realmObject, object, cache) : copy(realm, object, update, cache);
    }

    public static com.Realm.entry.GoodsClassBean copy(Realm realm, com.Realm.entry.GoodsClassBean newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.Realm.entry.GoodsClassBean) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.Realm.entry.GoodsClassBean realmObject = realm.createObjectInternal(com.Realm.entry.GoodsClassBean.class, ((GoodsClassBeanRealmProxyInterface) newObject).realmGet$gid(), false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        GoodsClassBeanRealmProxyInterface realmObjectSource = (GoodsClassBeanRealmProxyInterface) newObject;
        GoodsClassBeanRealmProxyInterface realmObjectCopy = (GoodsClassBeanRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$gName(realmObjectSource.realmGet$gName());
        realmObjectCopy.realmSet$num(realmObjectSource.realmGet$num());
        return realmObject;
    }

    public static long insert(Realm realm, com.Realm.entry.GoodsClassBean object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.Realm.entry.GoodsClassBean.class);
        long tableNativePtr = table.getNativePtr();
        GoodsClassBeanColumnInfo columnInfo = (GoodsClassBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.GoodsClassBean.class);
        long pkColumnIndex = columnInfo.gidIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((GoodsClassBeanRealmProxyInterface) object).realmGet$gid();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((GoodsClassBeanRealmProxyInterface) object).realmGet$gid());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((GoodsClassBeanRealmProxyInterface) object).realmGet$gid());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        String realmGet$gName = ((GoodsClassBeanRealmProxyInterface) object).realmGet$gName();
        if (realmGet$gName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.gNameIndex, rowIndex, realmGet$gName, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.numIndex, rowIndex, ((GoodsClassBeanRealmProxyInterface) object).realmGet$num(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.Realm.entry.GoodsClassBean.class);
        long tableNativePtr = table.getNativePtr();
        GoodsClassBeanColumnInfo columnInfo = (GoodsClassBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.GoodsClassBean.class);
        long pkColumnIndex = columnInfo.gidIndex;
        com.Realm.entry.GoodsClassBean object = null;
        while (objects.hasNext()) {
            object = (com.Realm.entry.GoodsClassBean) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((GoodsClassBeanRealmProxyInterface) object).realmGet$gid();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((GoodsClassBeanRealmProxyInterface) object).realmGet$gid());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((GoodsClassBeanRealmProxyInterface) object).realmGet$gid());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, rowIndex);
            String realmGet$gName = ((GoodsClassBeanRealmProxyInterface) object).realmGet$gName();
            if (realmGet$gName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.gNameIndex, rowIndex, realmGet$gName, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.numIndex, rowIndex, ((GoodsClassBeanRealmProxyInterface) object).realmGet$num(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.Realm.entry.GoodsClassBean object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.Realm.entry.GoodsClassBean.class);
        long tableNativePtr = table.getNativePtr();
        GoodsClassBeanColumnInfo columnInfo = (GoodsClassBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.GoodsClassBean.class);
        long pkColumnIndex = columnInfo.gidIndex;
        long rowIndex = Table.NO_MATCH;
        Object primaryKeyValue = ((GoodsClassBeanRealmProxyInterface) object).realmGet$gid();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((GoodsClassBeanRealmProxyInterface) object).realmGet$gid());
        }
        if (rowIndex == Table.NO_MATCH) {
            rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((GoodsClassBeanRealmProxyInterface) object).realmGet$gid());
        }
        cache.put(object, rowIndex);
        String realmGet$gName = ((GoodsClassBeanRealmProxyInterface) object).realmGet$gName();
        if (realmGet$gName != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.gNameIndex, rowIndex, realmGet$gName, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.gNameIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.numIndex, rowIndex, ((GoodsClassBeanRealmProxyInterface) object).realmGet$num(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.Realm.entry.GoodsClassBean.class);
        long tableNativePtr = table.getNativePtr();
        GoodsClassBeanColumnInfo columnInfo = (GoodsClassBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.GoodsClassBean.class);
        long pkColumnIndex = columnInfo.gidIndex;
        com.Realm.entry.GoodsClassBean object = null;
        while (objects.hasNext()) {
            object = (com.Realm.entry.GoodsClassBean) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = Table.NO_MATCH;
            Object primaryKeyValue = ((GoodsClassBeanRealmProxyInterface) object).realmGet$gid();
            if (primaryKeyValue != null) {
                rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((GoodsClassBeanRealmProxyInterface) object).realmGet$gid());
            }
            if (rowIndex == Table.NO_MATCH) {
                rowIndex = OsObject.createRowWithPrimaryKey(table, pkColumnIndex, ((GoodsClassBeanRealmProxyInterface) object).realmGet$gid());
            }
            cache.put(object, rowIndex);
            String realmGet$gName = ((GoodsClassBeanRealmProxyInterface) object).realmGet$gName();
            if (realmGet$gName != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.gNameIndex, rowIndex, realmGet$gName, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.gNameIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.numIndex, rowIndex, ((GoodsClassBeanRealmProxyInterface) object).realmGet$num(), false);
        }
    }

    public static com.Realm.entry.GoodsClassBean createDetachedCopy(com.Realm.entry.GoodsClassBean realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.Realm.entry.GoodsClassBean unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.Realm.entry.GoodsClassBean();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.Realm.entry.GoodsClassBean) cachedObject.object;
            }
            unmanagedObject = (com.Realm.entry.GoodsClassBean) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        GoodsClassBeanRealmProxyInterface unmanagedCopy = (GoodsClassBeanRealmProxyInterface) unmanagedObject;
        GoodsClassBeanRealmProxyInterface realmSource = (GoodsClassBeanRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$gid(realmSource.realmGet$gid());
        unmanagedCopy.realmSet$gName(realmSource.realmGet$gName());
        unmanagedCopy.realmSet$num(realmSource.realmGet$num());

        return unmanagedObject;
    }

    static com.Realm.entry.GoodsClassBean update(Realm realm, com.Realm.entry.GoodsClassBean realmObject, com.Realm.entry.GoodsClassBean newObject, Map<RealmModel, RealmObjectProxy> cache) {
        GoodsClassBeanRealmProxyInterface realmObjectTarget = (GoodsClassBeanRealmProxyInterface) realmObject;
        GoodsClassBeanRealmProxyInterface realmObjectSource = (GoodsClassBeanRealmProxyInterface) newObject;
        realmObjectTarget.realmSet$gName(realmObjectSource.realmGet$gName());
        realmObjectTarget.realmSet$num(realmObjectSource.realmGet$num());
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("GoodsClassBean = proxy[");
        stringBuilder.append("{gid:");
        stringBuilder.append(realmGet$gid());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{gName:");
        stringBuilder.append(realmGet$gName() != null ? realmGet$gName() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{num:");
        stringBuilder.append(realmGet$num());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GoodsClassBeanRealmProxy aGoodsClassBean = (GoodsClassBeanRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aGoodsClassBean.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aGoodsClassBean.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aGoodsClassBean.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
