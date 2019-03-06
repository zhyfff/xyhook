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
public class HostBeanRealmProxy extends com.Realm.entry.HostBean
    implements RealmObjectProxy, HostBeanRealmProxyInterface {

    static final class HostBeanColumnInfo extends ColumnInfo {
        long hostnameIndex;
        long servletnameIndex;

        HostBeanColumnInfo(OsSchemaInfo schemaInfo) {
            super(2);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("HostBean");
            this.hostnameIndex = addColumnDetails("hostname", objectSchemaInfo);
            this.servletnameIndex = addColumnDetails("servletname", objectSchemaInfo);
        }

        HostBeanColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new HostBeanColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final HostBeanColumnInfo src = (HostBeanColumnInfo) rawSrc;
            final HostBeanColumnInfo dst = (HostBeanColumnInfo) rawDst;
            dst.hostnameIndex = src.hostnameIndex;
            dst.servletnameIndex = src.servletnameIndex;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>(2);
        fieldNames.add("hostname");
        fieldNames.add("servletname");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    private HostBeanColumnInfo columnInfo;
    private ProxyState<com.Realm.entry.HostBean> proxyState;

    HostBeanRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (HostBeanColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.Realm.entry.HostBean>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$hostname() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.hostnameIndex);
    }

    @Override
    public void realmSet$hostname(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.hostnameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.hostnameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.hostnameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.hostnameIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$servletname() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.servletnameIndex);
    }

    @Override
    public void realmSet$servletname(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.servletnameIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.servletnameIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.servletnameIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.servletnameIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("HostBean", 2, 0);
        builder.addPersistedProperty("hostname", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("servletname", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static HostBeanColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new HostBeanColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "HostBean";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.Realm.entry.HostBean createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.Realm.entry.HostBean obj = realm.createObjectInternal(com.Realm.entry.HostBean.class, true, excludeFields);

        final HostBeanRealmProxyInterface objProxy = (HostBeanRealmProxyInterface) obj;
        if (json.has("hostname")) {
            if (json.isNull("hostname")) {
                objProxy.realmSet$hostname(null);
            } else {
                objProxy.realmSet$hostname((String) json.getString("hostname"));
            }
        }
        if (json.has("servletname")) {
            if (json.isNull("servletname")) {
                objProxy.realmSet$servletname(null);
            } else {
                objProxy.realmSet$servletname((String) json.getString("servletname"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.Realm.entry.HostBean createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.Realm.entry.HostBean obj = new com.Realm.entry.HostBean();
        final HostBeanRealmProxyInterface objProxy = (HostBeanRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("hostname")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$hostname((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$hostname(null);
                }
            } else if (name.equals("servletname")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$servletname((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$servletname(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    public static com.Realm.entry.HostBean copyOrUpdate(Realm realm, com.Realm.entry.HostBean object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
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
            return (com.Realm.entry.HostBean) cachedRealmObject;
        }

        return copy(realm, object, update, cache);
    }

    public static com.Realm.entry.HostBean copy(Realm realm, com.Realm.entry.HostBean newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.Realm.entry.HostBean) cachedRealmObject;
        }

        // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
        com.Realm.entry.HostBean realmObject = realm.createObjectInternal(com.Realm.entry.HostBean.class, false, Collections.<String>emptyList());
        cache.put(newObject, (RealmObjectProxy) realmObject);

        HostBeanRealmProxyInterface realmObjectSource = (HostBeanRealmProxyInterface) newObject;
        HostBeanRealmProxyInterface realmObjectCopy = (HostBeanRealmProxyInterface) realmObject;

        realmObjectCopy.realmSet$hostname(realmObjectSource.realmGet$hostname());
        realmObjectCopy.realmSet$servletname(realmObjectSource.realmGet$servletname());
        return realmObject;
    }

    public static long insert(Realm realm, com.Realm.entry.HostBean object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.Realm.entry.HostBean.class);
        long tableNativePtr = table.getNativePtr();
        HostBeanColumnInfo columnInfo = (HostBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.HostBean.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$hostname = ((HostBeanRealmProxyInterface) object).realmGet$hostname();
        if (realmGet$hostname != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.hostnameIndex, rowIndex, realmGet$hostname, false);
        }
        String realmGet$servletname = ((HostBeanRealmProxyInterface) object).realmGet$servletname();
        if (realmGet$servletname != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.servletnameIndex, rowIndex, realmGet$servletname, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.Realm.entry.HostBean.class);
        long tableNativePtr = table.getNativePtr();
        HostBeanColumnInfo columnInfo = (HostBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.HostBean.class);
        com.Realm.entry.HostBean object = null;
        while (objects.hasNext()) {
            object = (com.Realm.entry.HostBean) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$hostname = ((HostBeanRealmProxyInterface) object).realmGet$hostname();
            if (realmGet$hostname != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.hostnameIndex, rowIndex, realmGet$hostname, false);
            }
            String realmGet$servletname = ((HostBeanRealmProxyInterface) object).realmGet$servletname();
            if (realmGet$servletname != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.servletnameIndex, rowIndex, realmGet$servletname, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.Realm.entry.HostBean object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.Realm.entry.HostBean.class);
        long tableNativePtr = table.getNativePtr();
        HostBeanColumnInfo columnInfo = (HostBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.HostBean.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        String realmGet$hostname = ((HostBeanRealmProxyInterface) object).realmGet$hostname();
        if (realmGet$hostname != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.hostnameIndex, rowIndex, realmGet$hostname, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.hostnameIndex, rowIndex, false);
        }
        String realmGet$servletname = ((HostBeanRealmProxyInterface) object).realmGet$servletname();
        if (realmGet$servletname != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.servletnameIndex, rowIndex, realmGet$servletname, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.servletnameIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.Realm.entry.HostBean.class);
        long tableNativePtr = table.getNativePtr();
        HostBeanColumnInfo columnInfo = (HostBeanColumnInfo) realm.getSchema().getColumnInfo(com.Realm.entry.HostBean.class);
        com.Realm.entry.HostBean object = null;
        while (objects.hasNext()) {
            object = (com.Realm.entry.HostBean) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            String realmGet$hostname = ((HostBeanRealmProxyInterface) object).realmGet$hostname();
            if (realmGet$hostname != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.hostnameIndex, rowIndex, realmGet$hostname, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.hostnameIndex, rowIndex, false);
            }
            String realmGet$servletname = ((HostBeanRealmProxyInterface) object).realmGet$servletname();
            if (realmGet$servletname != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.servletnameIndex, rowIndex, realmGet$servletname, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.servletnameIndex, rowIndex, false);
            }
        }
    }

    public static com.Realm.entry.HostBean createDetachedCopy(com.Realm.entry.HostBean realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.Realm.entry.HostBean unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.Realm.entry.HostBean();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.Realm.entry.HostBean) cachedObject.object;
            }
            unmanagedObject = (com.Realm.entry.HostBean) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        HostBeanRealmProxyInterface unmanagedCopy = (HostBeanRealmProxyInterface) unmanagedObject;
        HostBeanRealmProxyInterface realmSource = (HostBeanRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$hostname(realmSource.realmGet$hostname());
        unmanagedCopy.realmSet$servletname(realmSource.realmGet$servletname());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("HostBean = proxy[");
        stringBuilder.append("{hostname:");
        stringBuilder.append(realmGet$hostname() != null ? realmGet$hostname() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{servletname:");
        stringBuilder.append(realmGet$servletname() != null ? realmGet$servletname() : "null");
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
        HostBeanRealmProxy aHostBean = (HostBeanRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aHostBean.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aHostBean.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aHostBean.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
