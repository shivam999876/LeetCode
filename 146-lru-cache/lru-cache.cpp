class LRUCache
{
    int capacity;
    list<int> keys;
    unordered_map<int, pair<int, list<int>::iterator>> cache;

public:
    LRUCache(int cap) : capacity(cap) {}
    int get(int key)
    {
        if (cache.find(key) == cache.end())
            return -1;
        keys.erase(cache[key].second);
        keys.push_front(key);
        cache[key].second = keys.begin();
        return cache[key].first;
    }
    void put(int key, int value)
    {
        if (cache.find(key) != cache.end())
        {
            keys.erase(cache[key].second);
        }
        else if (cache.size() == capacity)
        {
            int lru = keys.back();
            keys.pop_back();
            cache.erase(lru);
        }
        keys.push_front(key);
        cache[key] = {value, keys.begin()};
    }
};

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache* obj = new LRUCache(capacity);
 * int param_1 = obj->get(key);
 * obj->put(key,value);
 */