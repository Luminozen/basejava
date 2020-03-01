/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for(int i = 0; i < size(); i++) {
            storage[i]=null;
        }
    }

    void save(Resume r) {
        storage[size()] = r;
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid))
                return storage[i];
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].uuid.equals(uuid)) {
                for (int j = i; j < size(); j++) {
                    if (j != size() - 1) {
                        Resume temp = storage[j + 1];
                        storage[j] = temp;
                    } else
                        storage[j] = null;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] cloneStorage = new Resume[size()];
        for (int i = 0; i < size(); i++)
            cloneStorage[i] = storage[i];
        return cloneStorage;
    }

    int size() {
        int storageSize = 0;
        for (int i = 0; i < storage.length; i++) {
            if (storage[i] != null)
                storageSize++;
            else
                break;
        }
        return storageSize;
    }
}
