#include<bits/stdc++.h>
using namespace std;
 
typedef long long ll;

void solve(int v){
    ll n;
    cin>>n;
    string s;
    cin>>s;
    ll ans=0,i=0;
    bool flag=true;
    while (i<n-2){
        if (s[i]==s[i+2]){
            ans++;
            while (i<n-2 && (s[i]==s[i+2]))i++;
            if (i<n-2)i++;
        }
        else ans++,i++;
    }
    if (i==n-2 && s[n-1]!=s[n-3])ans++;
    cout<<ans<<endl;
}

int main(){
    ios::sync_with_stdio(false);cin.tie(NULL);
    #ifndef ONLINE_JUDGE
        freopen("input.txt","r",stdin);
        freopen("output.txt","w",stdout);
    #endif
	int t=1;
	cin >> t;
    int i=1;
	while( i<=t ){
		solve(i);
        i++;
	}
}
